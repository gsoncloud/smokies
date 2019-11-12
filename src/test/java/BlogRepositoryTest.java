import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.smokies.blog.SmokiesApplication;
import com.smokies.blog.entity.Blog;
import com.smokies.blog.repository.BlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmokiesApplication.class)
@Configuration
public class BlogRepositoryTest {

	@Autowired
	BlogRepository subject;

	@Test
	public void createBlogTest() throws Exception {
		Blog blog = subject.save(new Blog("Unit test title", "unit test post"));
		Blog newBlog = subject.findById(blog.getId()).get();
		assertNotNull(newBlog);

	}

	@Test
	public void getAllBlogsTest() throws Exception {
		Blog blog = subject.save(new Blog("Unit test title", "unit test post"));
		List<Blog> blogs = subject.findAll();
		assertFalse(blogs.isEmpty());
		assertNotNull(blogs.get(0));
	}
}