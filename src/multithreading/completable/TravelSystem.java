package multithreading.completable;

import java.util.concurrent.CompletableFuture;

public class TravelSystem {

    public static void main(String[] args) {
        
        // 1. supplyAsync: Kick off the first background task
        CompletableFuture<String> pipeline = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user ID...");
            return "User_123";
        })
        // 2. thenApply: Transform the data (String ID -> User Object)
        .thenApply(id -> {
            System.out.println("Transforming ID to User Object...");
            return new User(id, "John Doe");
        })
        // 3. thenCompose: Chain a second DEPENDENT async task 
        // (We need the User object to fetch the Flight)
        .thenCompose(user -> {
            System.out.println("Fetching flight for " + user.name + "...");
            return fetchFlightAsync(user); 
        })
        // 4. thenCombine: Join an INDEPENDENT async task
        // (Fetch hotel at the same time as flight, then merge them)
        .thenCombine(fetchHotelAsync(), (flight, hotel) -> {
            return "Itinerary: " + flight + " + " + hotel;
        });

        // 5. thenAccept: The finish line (Consumer)
        pipeline.thenAccept((String finalItinerary) -> {
            System.out.println("Booking Complete! " + finalItinerary);
        });

        // Keep the program alive long enough to see the async results
        pipeline.join();
    }

    // Mock async method for thenCompose
    static CompletableFuture<String> fetchFlightAsync(User user) {
        return CompletableFuture.supplyAsync(() -> "Flight_SK451");
    }

    // Mock async method for thenCombine
    static CompletableFuture<String> fetchHotelAsync() {
        return CompletableFuture.supplyAsync(() -> "Hilton Hotel");
    }

    static class User {
        String id;
        String name;
        User(String id, String name) { this.id = id; this.name = name; }
    }
}
