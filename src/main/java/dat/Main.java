package dat;

import ch.qos.logback.classic.Logger;
import dat.config.HibernateConfig;
import dat.daos.MovieDAO;
import dat.dtos.MovieDTO;
import dat.services.MovieAsyncServices;
import dat.services.MovieSyncServices;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("movies");

        // 1. Get all movie ids released after a certain date
   //     int[] movieIds = MovieSyncServices.getDanishMovieIdsReleasedAfter(LocalDate.of(2019, 9, 18), 1);
     //   System.out.println(Arrays.toString(movieIds));
        //int[] movieIds = MovieSyncServices.movieIds;
        int[] movieIds = MovieSyncServices.testMovieIds;

        // 2. Get the details for each movie
        long startTime = System.currentTimeMillis();

        List<MovieDTO> movieDTOs = MovieSyncServices.getMovieDetails(movieIds);
        //List<MovieDTO> movieDTOs = MovieAsyncServices.getMovieDetailsAsync(movieIds);

        long fetchTime = System.currentTimeMillis();
        long duration = fetchTime - startTime;
        logger.info("Async Fetch Task runtime: " + duration + " milliseconds");

        // 3. Persist the MovieDTOs to the database.
        MovieDAO movieDAO = MovieDAO.getInstance(emf);
        movieDTOs.forEach(movieDAO::create);

        // 4. Get all movies and print them

        //List<MovieDTO> movieDTOsForPrint = movieDAO.getAll();
        //movieDTOs.forEach(System.out::println);

        long saveTime = System.currentTimeMillis();
        duration = saveTime - fetchTime;
        logger.info("Save Task runtime: " + duration + " milliseconds");
        emf.close();


    }
}