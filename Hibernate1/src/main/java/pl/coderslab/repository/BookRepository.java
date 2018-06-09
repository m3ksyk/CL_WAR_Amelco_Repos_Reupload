package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> , BookRepoCustom {

    List<Book> findAllByTitle(String title);
    List<Book> findAllByAuthors(List<Author> authors);
    List<Book> findAllByAuthorsId(Long authorsId);

    @Query("Select b From Book b Join b.authors a Where a.id = :authorId")
    List<Book> findAllByAuthorId(@Param("authorId") Long authorId);

    List<Book> findAllByPublisherId(long publisherId);

    List<Book> findByRatingEquals(int rating);

//there is no category field int book class!!
//    Book findFirstByCategoryOrderByTitle(String category);
    @Query("Select b from Book b where b.title like :title")
    List<Book> findBooksByTitlePart(@Param("title") String titlePart);

    @Query("Select b From Book b Join b.authors a Where a in :authors")
    List<Book> findAllByAuthor(@Param("authors") List<Author> authors);

    @Query("Select b from Book b where b.rating between :rat1 and :rat2")
    List<Book> findWithRating(@Param("rat1") int rating1, @Param("rat2") int rating2);

    @Query("Select b from Book b join b.publisher p where p like :publisher")
    List<Book> findBooksByPublisher(@Param("publisher") Publisher publisher);

//    @Query("Select first b from Book b where category = :category order by b.title")
//    Book findFirstByCategoryOrderByTitle(@Param("category") String category);

}
