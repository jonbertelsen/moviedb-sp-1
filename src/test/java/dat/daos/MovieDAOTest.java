package dat.daos;

import dat.config.HibernateConfig;
import dat.dtos.MovieDTO;
import dat.services.JsonServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovieDAOTest {

    private final static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryForTest();
    private final static MovieDAO movieDAO = MovieDAO.getInstance(emf);
    private static MovieDTO m1, m2;


    @BeforeEach
    void setUp() {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            String json1 = "{\"adult\":false,\"backdrop_path\":\"/7i6F8CiBDHrZ1THxlsjF9EiSkXd.jpg\",\"belongs_to_collection\":{\"id\":894040,\"name\":\"Ternet Ninja (Samling)\",\"poster_path\":\"/pZQkRmLgVuZkfRt1S8W5zIZVBh2.jpg\",\"backdrop_path\":\"/mQxYHzhlfsvDWA4UzMeQaA0lYV5.jpg\"},\"budget\":0,\"genres\":[{\"id\":16,\"name\":\"Animation\"},{\"id\":35,\"name\":\"Comedy\"},{\"id\":28,\"name\":\"Action\"},{\"id\":10751,\"name\":\"Family\"}],\"homepage\":\"\",\"id\":778819,\"imdb_id\":\"tt13387604\",\"origin_country\":[\"DK\"],\"original_language\":\"da\",\"original_title\":\"Ternet Ninja 2\",\"overview\":\"After Phillip Eppermint manages to evade a prison sentence in Thailand, Checkered Ninja comes alive and seeks out Alex. Together, with Alex and his entire family, they now have to go to Thailand to bust Eppermint.\",\"popularity\":8.148,\"poster_path\":\"/fjWiVF2vFwd3mhs1dNoS0SOHxqt.jpg\",\"production_companies\":[{\"id\":3922,\"logo_path\":\"/uXDOnG25HLnban0UfpRVjxASMWW.png\",\"name\":\"A. Film Production\",\"origin_country\":\"DK\"},{\"id\":116794,\"logo_path\":null,\"name\":\"Pop Up Production\",\"origin_country\":\"DK\"},{\"id\":146111,\"logo_path\":null,\"name\":\"Sudoku ApS\",\"origin_country\":\"\"},{\"id\":54944,\"logo_path\":\"/AvcxOJ3K9CNP6DzYSUDOJ41e3JG.png\",\"name\":\"Noori Pictures\",\"origin_country\":\"FR\"}],\"production_countries\":[{\"iso_3166_1\":\"DK\",\"name\":\"Denmark\"}],\"release_date\":\"2021-08-19\",\"revenue\":0,\"runtime\":86,\"spoken_languages\":[{\"english_name\":\"Danish\",\"iso_639_1\":\"da\",\"name\":\"Dansk\"},{\"english_name\":\"Norwegian\",\"iso_639_1\":\"no\",\"name\":\"Norsk\"}],\"status\":\"Released\",\"tagline\":\"\",\"title\":\"Checkered Ninja 2\",\"video\":false,\"vote_average\":6.512,\"vote_count\":42,\"credits\":{\"cast\":[{\"adult\":false,\"gender\":2,\"id\":66843,\"known_for_department\":\"Acting\",\"name\":\"Anders Matthesen\",\"original_name\":\"Anders Matthesen\",\"popularity\":2.729,\"profile_path\":\"/46X1sw2Y5i2aABqcdUZXM0WTGgW.jpg\",\"cast_id\":10,\"character\":\"(voice)\",\"credit_id\":\"600de373391b9c0040d9aa57\",\"order\":0},{\"adult\":false,\"gender\":2,\"id\":2950667,\"known_for_department\":\"Acting\",\"name\":\"Louis Næss-Schmidt\",\"original_name\":\"Louis Næss-Schmidt\",\"popularity\":2.228,\"profile_path\":\"/ui4oiYjLrjYfrmg9KIfRlskeHSB.jpg\",\"cast_id\":11,\"character\":\"Aske (voice)\",\"credit_id\":\"600de384006eee003b82ac77\",\"order\":1},{\"adult\":false,\"gender\":1,\"id\":89962,\"known_for_department\":\"Acting\",\"name\":\"Emma Sehested Høeg\",\"original_name\":\"Emma Sehested Høeg\",\"popularity\":3.94,\"profile_path\":\"/kuxXo48TFD00kpMpVKSMGNMWv7G.jpg\",\"cast_id\":12,\"character\":\"Jessica (voice)\",\"credit_id\":\"600de3939a6435003f90e6a2\",\"order\":2}],\"crew\":[{\"adult\":false,\"gender\":0,\"id\":73101,\"known_for_department\":\"Production\",\"name\":\"Anders Mastrup\",\"original_name\":\"Anders Mastrup\",\"popularity\":1.007,\"profile_path\":null,\"credit_id\":\"5fe265ef357c00003f486e2c\",\"department\":\"Production\",\"job\":\"Producer\"},{\"adult\":false,\"gender\":0,\"id\":147209,\"known_for_department\":\"Directing\",\"name\":\"Mads Juul\",\"original_name\":\"Mads Juul\",\"popularity\":1.055,\"profile_path\":null,\"credit_id\":\"5fe2661f357c00004048785a\",\"department\":\"Art\",\"job\":\"Storyboard Artist\"},{\"adult\":false,\"gender\":0,\"id\":66880,\"known_for_department\":\"Directing\",\"name\":\"Thorbjørn Christoffersen\",\"original_name\":\"Thorbjørn Christoffersen\",\"popularity\":1.322,\"profile_path\":null,\"credit_id\":\"5fe26580a0b6b5003d117b34\",\"department\":\"Directing\",\"job\":\"Director\"},{\"adult\":false,\"gender\":2,\"id\":66843,\"known_for_department\":\"Acting\",\"name\":\"Anders Matthesen\",\"original_name\":\"Anders Matthesen\",\"popularity\":2.729,\"profile_path\":\"/46X1sw2Y5i2aABqcdUZXM0WTGgW.jpg\",\"credit_id\":\"5fe2659070309f003e7de352\",\"department\":\"Writing\",\"job\":\"Screenplay\"},{\"adult\":false,\"gender\":2,\"id\":66843,\"known_for_department\":\"Acting\",\"name\":\"Anders Matthesen\",\"original_name\":\"Anders Matthesen\",\"popularity\":2.729,\"profile_path\":\"/46X1sw2Y5i2aABqcdUZXM0WTGgW.jpg\",\"credit_id\":\"5fe2659772d855003bbfdd51\",\"department\":\"Writing\",\"job\":\"Book\"},{\"adult\":false,\"gender\":0,\"id\":1725880,\"known_for_department\":\"Directing\",\"name\":\"Cemille Matthesen\",\"original_name\":\"Cemille Matthesen\",\"popularity\":0.001,\"profile_path\":null,\"credit_id\":\"5fe2660951f99a004094ba1c\",\"department\":\"Production\",\"job\":\"Co-Producer\"},{\"adult\":false,\"gender\":2,\"id\":66843,\"known_for_department\":\"Acting\",\"name\":\"Anders Matthesen\",\"original_name\":\"Anders Matthesen\",\"popularity\":2.729,\"profile_path\":\"/46X1sw2Y5i2aABqcdUZXM0WTGgW.jpg\",\"credit_id\":\"5fe2657289d97f003d9366d2\",\"department\":\"Directing\",\"job\":\"Director\"},{\"adult\":false,\"gender\":0,\"id\":66846,\"known_for_department\":\"Production\",\"name\":\"Trine Heidegaard\",\"original_name\":\"Trine Heidegaard\",\"popularity\":0.543,\"profile_path\":null,\"credit_id\":\"5fe265fb3a4a120040eeaaab\",\"department\":\"Production\",\"job\":\"Co-Producer\"},{\"adult\":false,\"gender\":2,\"id\":1774410,\"known_for_department\":\"Directing\",\"name\":\"Kristian Håskjold\",\"original_name\":\"Kristian Håskjold\",\"popularity\":1.785,\"profile_path\":\"/9EGuCUFKbOMxpjcwRhcNuWFvuCI.jpg\",\"credit_id\":\"5fe2661372d855003cbfe3ae\",\"department\":\"Editing\",\"job\":\"Editor\"}]}}";
            String json2 = "{\"adult\":false,\"backdrop_path\":null,\"belongs_to_collection\":null,\"budget\":0,\"genres\":[],\"homepage\":\"\",\"id\":1317159,\"imdb_id\":\"tt30886032\",\"origin_country\":[\"DK\"],\"original_language\":\"da\",\"original_title\":\"Vejen hjem\",\"overview\":\"How far are you willing to go to save the people you love? This is the question Christian (Nikolaj Lie Kaas) is forced to answer when he is smuggled into Syria in a desperate search for his son Adam. It's a deadly and soul-searching journey into a brutal, war-torn country. Gradually, Christian realises that he must be willing to sacrifice everything he believes in to be reunited with his son. WAY HOME is a powerful and gripping drama about powerlessness, forgiveness and the love for our children.\",\"popularity\":2.104,\"poster_path\":\"/r2WrwFYxYuNnS13mWRldngdj3nx.jpg\",\"production_companies\":[],\"production_countries\":[],\"release_date\":\"2024-08-20\",\"revenue\":0,\"runtime\":98,\"spoken_languages\":[{\"english_name\":\"Danish\",\"iso_639_1\":\"da\",\"name\":\"Dansk\"}],\"status\":\"Released\",\"tagline\":\"\",\"title\":\"Way Home\",\"video\":false,\"vote_average\":3.0,\"vote_count\":1,\"credits\":{\"cast\":[{\"adult\":false,\"gender\":2,\"id\":1018,\"known_for_department\":\"Acting\",\"name\":\"Nikolaj Lie Kaas\",\"original_name\":\"Nikolaj Lie Kaas\",\"popularity\":8.309,\"profile_path\":\"/aU7YfSyQxxOwiNyXuaW0YRgpYyg.jpg\",\"cast_id\":2,\"character\":\"Christian\",\"credit_id\":\"66c42e8f7a13c85dba97061c\",\"order\":0},{\"adult\":false,\"gender\":2,\"id\":1552847,\"known_for_department\":\"Acting\",\"name\":\"Albert Rudbeck Lindhardt\",\"original_name\":\"Albert Rudbeck Lindhardt\",\"popularity\":3.071,\"profile_path\":\"/iEvh3kr3ZTfxjUdWvXCLPUUsx.jpg\",\"cast_id\":3,\"character\":\"Adam\",\"credit_id\":\"66c42eac6fb60d13a975f48b\",\"order\":1},{\"adult\":false,\"gender\":2,\"id\":2661746,\"known_for_department\":\"Acting\",\"name\":\"Arian Kashef\",\"original_name\":\"Arian Kashef\",\"popularity\":1.892,\"profile_path\":\"/zXM8gC6kxyXpSKfLe46GNm887xs.jpg\",\"cast_id\":4,\"character\":\"Abu Hassan\",\"credit_id\":\"66c42ec9a5a309e5285d1775\",\"order\":2},{\"adult\":false,\"gender\":2,\"id\":1458362,\"known_for_department\":\"Acting\",\"name\":\"Besir Zeciri\",\"original_name\":\"Besir Zeciri\",\"popularity\":5.33,\"profile_path\":\"/13qjnv0nbIjzshbDEycHEg87Vyi.jpg\",\"cast_id\":5,\"character\":\"Abu Amin\",\"credit_id\":\"66c42ee926f0991085d1186b\",\"order\":3},{\"adult\":false,\"gender\":2,\"id\":1508552,\"known_for_department\":\"Acting\",\"name\":\"Harki Bhambra\",\"original_name\":\"Harki Bhambra\",\"popularity\":3.637,\"profile_path\":\"/5U7u9119kOJV1ELgOv8SamvOAtc.jpg\",\"cast_id\":6,\"character\":\"Bilal\",\"credit_id\":\"66c42f0f71ec89bd83d100c4\",\"order\":4},{\"adult\":false,\"gender\":2,\"id\":1171128,\"known_for_department\":\"Acting\",\"name\":\"Tom Austen\",\"original_name\":\"Tom Austen\",\"popularity\":3.896,\"profile_path\":\"/6TC9gW3ZJzrNyFgsYDeWj8V6RYo.jpg\",\"cast_id\":7,\"character\":\"Abu Talha\",\"credit_id\":\"66c42f2bc4ad5ec7e1a3a7d2\",\"order\":5},{\"adult\":false,\"gender\":0,\"id\":3553678,\"known_for_department\":\"Acting\",\"name\":\"Majd Eid\",\"original_name\":\"Majd Eid\",\"popularity\":1.66,\"profile_path\":null,\"cast_id\":8,\"character\":\"Nazir\",\"credit_id\":\"66c42f4bcad67ccd691b0ef3\",\"order\":6},{\"adult\":false,\"gender\":0,\"id\":4895251,\"known_for_department\":\"Acting\",\"name\":\"Ahmad Al-Sukar\",\"original_name\":\"Ahmad Al-Sukar\",\"popularity\":0.621,\"profile_path\":null,\"cast_id\":9,\"character\":\"Hamza\",\"credit_id\":\"66c42f62bf5b9cd09ca3a7f9\",\"order\":7}],\"crew\":[{\"adult\":false,\"gender\":1,\"id\":72372,\"known_for_department\":\"Acting\",\"name\":\"Charlotte Sieling\",\"original_name\":\"Charlotte Sieling\",\"popularity\":2.138,\"profile_path\":\"/hcgSpUhuQV94zTsdkCuAXGUvKRL.jpg\",\"credit_id\":\"669527897f611dc9d9a97475\",\"department\":\"Directing\",\"job\":\"Director\"},{\"adult\":false,\"gender\":1,\"id\":72372,\"known_for_department\":\"Acting\",\"name\":\"Charlotte Sieling\",\"original_name\":\"Charlotte Sieling\",\"popularity\":2.138,\"profile_path\":\"/hcgSpUhuQV94zTsdkCuAXGUvKRL.jpg\",\"credit_id\":\"66c42fb80660c0b4ad75fa14\",\"department\":\"Writing\",\"job\":\"Writer\"},{\"adult\":false,\"gender\":2,\"id\":1959114,\"known_for_department\":\"Writing\",\"name\":\"Jesper Fink\",\"original_name\":\"Jesper Fink\",\"popularity\":1.045,\"profile_path\":\"/8k1qtFOGeYPRhAcGLw1imSKZgY7.jpg\",\"credit_id\":\"66c42fd260fbea31faa3a7d3\",\"department\":\"Writing\",\"job\":\"Writer\"},{\"adult\":false,\"gender\":0,\"id\":1266259,\"known_for_department\":\"Writing\",\"name\":\"Nagieb Khaja\",\"original_name\":\"Nagieb Khaja\",\"popularity\":0.001,\"profile_path\":null,\"credit_id\":\"66c42fed412d66ceafadbf36\",\"department\":\"Writing\",\"job\":\"Writer\"}]}}";
            m1 = JsonServices.convertJsonToObject(json1, MovieDTO.class);
            m2 = JsonServices.convertJsonToObject(json2, MovieDTO.class);
            m1 = movieDAO.create(m1);
            m2 = movieDAO.create(m2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.createQuery("DELETE FROM ProductionCompany ").executeUpdate();
            em.createQuery("DELETE FROM ProductionCountry ").executeUpdate();
            em.createQuery("DELETE FROM SpokenLanguage ").executeUpdate();
            em.createQuery("DELETE FROM Genre").executeUpdate();
            em.createQuery("DELETE FROM Movie").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    void afterAll(){
        emf.close();
    }

    @Test
    void create() {
        String json3 = "{\"adult\":false,\"backdrop_path\":null,\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":99,\"name\":\"Documentary\"}],\"homepage\":\"\",\"id\":1108283,\"imdb_id\":null,\"origin_country\":[\"DK\"],\"original_language\":\"en\",\"original_title\":\"Veras jord - planter har også følelser\",\"overview\":\"12-year-old Vera doesn’t go to school, she goes to the garden. Here she grows her own vegetable garden, learning more about nature and why it makes her garden makes her so happy.\",\"popularity\":0.34,\"poster_path\":null,\"production_companies\":[],\"production_countries\":[{\"iso_3166_1\":\"DK\",\"name\":\"Denmark\"}],\"release_date\":\"2023-03-16\",\"revenue\":0,\"runtime\":47,\"spoken_languages\":[],\"status\":\"Released\",\"tagline\":\"\",\"title\":\"Plants Have Feelings Too\",\"video\":false,\"vote_average\":0.0,\"vote_count\":0,\"credits\":{\"cast\":[],\"crew\":[{\"adult\":false,\"gender\":0,\"id\":3992333,\"known_for_department\":\"Directing\",\"name\":\"Sara Loa Bro\",\"original_name\":\"Sara Loa Bro\",\"popularity\":0.001,\"profile_path\":null,\"credit_id\":\"642abca2ac8e6b00778493e4\",\"department\":\"Directing\",\"job\":\"Director\"}]}}";
        MovieDTO m3 = JsonServices.convertJsonToObject(json3, MovieDTO.class);
        m3 = movieDAO.create(m3);
        assertEquals(1108283, m3.getId());
        List<MovieDTO> movieDTOS = movieDAO.getAll();
        assertEquals(3, movieDTOS.size());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        movieDAO.delete(m1.getId());
        List<MovieDTO> movieDTOS = movieDAO.getAll();
        assertEquals(1, movieDTOS.size());
        assertEquals(m2.getId(), movieDTOS.get(0).getId());
    }

    @Test
    void getAll() {
        List<MovieDTO> movieDTOS = movieDAO.getAll();
        assertEquals(2, movieDTOS.size());
    }

    @Test
    void getById() {
        MovieDTO movieDTO = movieDAO.getById(m1.getId());
        assertEquals(m1.getOriginalTitle(), movieDTO.getOriginalTitle());
    }
}