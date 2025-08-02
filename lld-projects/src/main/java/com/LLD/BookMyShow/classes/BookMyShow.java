package com.LLD.BookMyShow.classes;

import com.LLD.BookMyShow.enums.City;
import com.LLD.BookMyShow.enums.SeatCategory;
import java.util.*;

public class BookMyShow {

    static MovieController movieController;
    static TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        BookMyShow.createBooking(City.PUNE,"PS1");
        BookMyShow.createBooking(City.PUNE,"PS1");
    }

    private static void createBooking(City city, String movieName) {

        //1. Get movie by movie name
        Movie interestedMovie = movieController.getMovieByName(movieName,city);

        //2. get theatres' with matching shows for interested movie
        Map<Theatre,List<Show>> theatreVsShows = theatreController.getAllShows(interestedMovie,city);

        //3. select interested show
        Show interestedShow =  theatreVsShows.entrySet().iterator().next().getValue().get(0);


        //4. seat number
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();

        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);

            //5. Payment
            Booking booking = new Booking();
            booking.setShow(interestedShow);
            booking.setPayment(new Payment(UUID.randomUUID().toString()));
        System.out.println("BOOKING SUCCESSFUL!!!!!!!");
        }else{
            System.out.println("Seat already booked. TRY AGAIN!");
        }
    }


    private void initialize() {

        //create Movies
        createMovies();

        //create theatres
        createTheatres();
    }

    private static void createTheatres() {

    //    TheatreController theatreController = new TheatreController();

        Movie ps1 = movieController.getMovieByName("PS1",City.PUNE);
        Movie ps2 = movieController.getMovieByName("PS2",City.BANGLORE);

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setId(1);
        inoxTheatre.setCity(City.PUNE);
        Screen inoxScreen1 = getScreen(1);
        Screen inoxScreen2 = getScreen(2);
        inoxTheatre.setScreens(Arrays.asList(inoxScreen1,inoxScreen2));
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreens().get(0), ps1, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreens().get(0), ps2, 16);
        inoxTheatre.setShows(Arrays.asList(inoxMorningShow,inoxEveningShow));


        theatreController.addTheatre(inoxTheatre,City.PUNE);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setId(2);
        pvrTheatre.setCity(City.PUNE);
        Screen pvrScreen1 = getScreen(1);
        Screen pvrScreen2 = getScreen(2);
        pvrTheatre.setScreens(Arrays.asList(pvrScreen1,pvrScreen2));

        Show pvrMorningShow = createShows(3, pvrTheatre.getScreens().get(0), ps1, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreens().get(0), ps2, 20);
        pvrTheatre.setShows(Arrays.asList(pvrMorningShow,pvrEveningShow));

        theatreController.addTheatre(pvrTheatre,City.PUNE);

    }

    private static Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    private static Screen getScreen(Integer id) {
        Screen screen = new Screen();
        screen.setId(id);
        screen.setSeats(getSeats());

        return screen;
    }

    private static List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();

        for(int i=0;i<40;i++){
            Seat seat = new Seat();
            seat.setId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seat.setRow(SeatCategory.SILVER.name());
            seats.add(seat);
        }

        for(int i=40;i<70;i++){
            Seat seat = new Seat();
            seat.setId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seat.setRow(SeatCategory.GOLD.name());
            seats.add(seat);
        }

        for(int i=70;i<100;i++){
            Seat seat = new Seat();
            seat.setId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seat.setRow(SeatCategory.PLATINUM.name());
            seats.add(seat);
        }

        return seats;
    }

    private static void createMovies() {
//        MovieController movieController = new MovieController();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setName("PS1");

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setName("PS2");

        movieController.addMovie(movie1, City.PUNE);
        movieController.addMovie(movie2,City.BANGLORE);

    }
}
