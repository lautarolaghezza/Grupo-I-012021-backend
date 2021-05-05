package ar.edu.unq.desapp.grupoi.backenddesappapi.service;


public class ReviewServiceTest {
 //   public ReviewServiceImpl reviewService;
 //   public PublicReview review1;
 //   public PublicReview review2;
 //   public PublicReview review3;
 //   public CommonUserAbs juan;
 //   public Filter filterPlatform;
 //   public Filter filterSpoilerAlert;
 //   public Filter filterTypeUser1;
 //   public Filter filterTypeUser2;
 //   public Filter filterLanguage;
 //   public Filter filterLocation;
//
 //   @BeforeEach
 //   public void setUp(){
//
 //       filterPlatform = new PlatformFilter(Platform.NETFLIX);
 //       filterSpoilerAlert = new SpoilerAlertFilter(true);
 //       filterTypeUser1 = new TypeUserFilter(Type_User.COMMON);
 //       filterTypeUser2 = new TypeUserFilter(Type_User.CRITIC);
 //       filterLanguage = new LanguageFilter("SPANISH");
 //       filterLocation = new LocationFilter("ARGENTINA");
//
 //       juan = new CommonUserAbs(1, Platform.NETFLIX, Type_User.COMMON,
 //               "Juancito",
 //               "Argentina");
 //       this.reviewService = new ReviewServiceImpl();
//
 //       review1 = juan.createReview(
 //               "pdc1",
 //               "muy buena pelicula de Ciencia ficcion",
 //               "Me parecio una muy buena pelicula",
 //               3,
 //               LocalDate.of(2021,4,25),
 //               "Spanish",
 //               true);
 //       review2 = juan.createReview(
 //               "pdc1",
 //               "muy buena pelicula de Ciencia ficcion",
 //               "Me parecio una muy buena pelicula",
 //               5, LocalDate.of(2000,12,24),
 //               "Spanish",
 //               false);
 //       review3 = juan.createReview(
 //               "pdc1",
 //               "cuenta la historia de neo",
 //               "es muy buena la historia",
 //               4, LocalDate.of(1990,11,5),
 //               "English",
 //               false);
 //       reviewService.save(juan, review1);
 //       reviewService.save(juan, review2);
 //       reviewService.save(juan, review3);
 //       }
 //   @Test
 //       public void addReviewTest(){
 //       PublicReview review4 = juan.createReview(
 //               "pdc1",
 //               "muy buena pelicula de Ciencia ficcion",
 //               "Me parecio una muy buena pelicula",
 //               3, LocalDate.now(),
 //               "Spanish", false);
 //       reviewService.save(juan, review4);
 //       Assertions.assertEquals(review3.getExtendedText(), reviewService.getReviews("review3").get(0).getExtendedText());
 //   }
//
 //   @Test
 //   public void getReviewsTest(){
 //       List<Review> result =  reviewService.findAll();
 //       review1 = juan.createReview(
 //               "review1",
 //               "muy mala pelicula ",
 //               "No la olveria a ver por nada",
 //               1,
 //               LocalDate.now(),
 //               "Spanish",
 //               false);
 //       Assertions.assertEquals(1, result.size());
 //   }
//
 //   @Test
 //   public void getReviewsWithFilterPlatformTest(){
 //       List<Filter> filters = new ArrayList<>();
 //       filters.add(filterPlatform);
 //       List<Review> result = reviewService.getReviewsWithFilter(filters);
//
 //       Assertions.assertEquals(3,result.size());
//
 //   }
//
 //   @Test
 //   public void getReviewsWithFilterLocationTest(){
 //       List<Filter> filters = new ArrayList<>();
 //       filters.add(filterLocation);
 //       List<Review> result = reviewService.getReviewsWithFilter(filters);
//
 //       Assertions.assertEquals(3,result.size());
//
 //   }
//
 //   @Test
 //   public void getReviewsWithFilter_spoiler_alertTest(){
 //       List<Filter> filters = new ArrayList<>();
 //       filters.add(filterSpoilerAlert);
 //       List<Review> result = reviewService.getReviewsWithFilter(filters);
//
 //       Assertions.assertEquals(1,result.size());
//
 //   }
//
 //   @Test
 //   public void getReviewsWithFilter_type_UserTest(){
 //       List<Filter> filters = new ArrayList<>();
 //       filters.add(filterTypeUser1);
 //       List<Review> result = reviewService.getReviewsWithFilter(filters);
//
 //       Assertions.assertEquals(3,result.size());
//
 //   }
 //   @Test
 //   public void getReviewsWithFilter_languageTest(){
 //       List<Filter> filters = new ArrayList<>();
 //       filters.add(filterLanguage);
 //       List<Review> result = reviewService.getReviewsWithFilter(filters);
//
 //       Assertions.assertEquals(2,result.size());
//
 //   }
//
 //   @Test
 //   public void orderByRatingAscTest(){
 //      List<Review> result = reviewService.orderByRatingAsc(reviewService.findAll());
 //      Assertions.assertEquals(3, result.get(0).getRating());
 //   }
//
 //   @Test
 //   public void orderByRatingDescTest(){
 //       List<Review> result = reviewService.orderByRatingDesc(reviewService.findAll());
 //       Assertions.assertEquals(5, result.get(0).getRating());
//
 //   }
//
 //   @Test
 //   public void orderByDateAscTest(){
 //       List<Review> result = reviewService.orderByDateAsc(reviewService.findAll());
 //       Assertions.assertEquals(LocalDate.of(1990,11,5), result.get(0).getDate());
//
 //   }
//
 //   @Test
 //   public void orderByDateDescTest(){
 //       List<Review> result = reviewService.orderByDateDesc(reviewService.findAll());
 //       Assertions.assertEquals(LocalDate.of(2021,4,25), result.get(0).getDate());
//
 //   }
//
 //   @Test
 //   public void reviewNotFoundTest(){
 //       assertThrows(ReviewsNotFoundException.class, ()-> this.reviewService.getReviews("not found"));
 //   }
//
 //   @Test
 //   public void repositorityNotNull(){
 //       Assertions.assertNotNull(reviewService.findAll());
 //   }
}
