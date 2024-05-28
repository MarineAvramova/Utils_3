import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@org.junit.jupiter.api.Test
	public void testDirectoryExistsAndIsDirectory() {
		String path = "C:\\Users\\Marine\\Documents";
		File directory = new File(path);
		assertTrue("Directory should exist", directory.exists());
		assertTrue("Path should be a directory", directory.isDirectory());
		
	}

}
