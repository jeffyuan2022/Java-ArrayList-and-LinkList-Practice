
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	@Test
	public void testIsEmpty() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertEquals(false, int_s.isEmpty());
		
		Integer[] empty_input = {};
		MyList<Integer> int_empty = makeList(empty_input);
		assertEquals(true, int_empty.isEmpty());
	}
	
	@Test
	public void testUpperCase() {
		String[] str_input_1 = {"a", "b", "c"};
		String[] str_output_1 = {"A", "B", "C"};
		MyList<String> abc = makeList(str_input_1);
		abc.transformAll(new UpperCaseTransformer());
		assertArrayEquals(str_output_1, abc.toArray());
		
		String[] str_input_2 = {"a", "b", null};
		String[] str_output_2 = {"A", "B", null};
		MyList<String> a_null = makeList(str_input_2);
		a_null.transformAll(new UpperCaseTransformer());
		assertArrayEquals(str_output_2, a_null.toArray());
		
		String[] str_input_3 = {};
		String[] str_output_3 = {};
		MyList<String> empty = makeList(str_input_3);
		empty.transformAll(new UpperCaseTransformer());
		assertArrayEquals(str_output_3, empty.toArray());
	}
	
	@Test
	public void testlengthCaseTransformer() {
		String[] str_input_1 = {"a", "bb", "ccc"};
		String[] str_output_1 = {"1", "2", "3"};
		MyList<String> abc = makeList(str_input_1);
		abc.transformAll(new lengthCaseTransformer());
		assertArrayEquals(str_output_1, abc.toArray());
		
		String[] str_input_2 = {"a", "b", null};
		String[] str_output_2 = {"1", "1", null};
		MyList<String> a_null = makeList(str_input_2);
		a_null.transformAll(new lengthCaseTransformer());
		assertArrayEquals(str_output_2, a_null.toArray());
		
		String[] str_input_3 = {};
		String[] str_output_3 = {};
		MyList<String> empty = makeList(str_input_3);
		empty.transformAll(new lengthCaseTransformer());
		assertArrayEquals(str_output_3, empty.toArray());
	}
	
	@Test
	public void testFirstThreeCaseTransformer() {
		String[] str_input_1 = {"a", "bbb", "ccccc"};
		String[] str_output_1 = {"a", "bbb", "ccc"};
		MyList<String> abc = makeList(str_input_1);
		abc.transformAll(new firstThreeLetterCaseTransformer());
		assertArrayEquals(str_output_1, abc.toArray());
		
		String[] str_input_2 = {"a", "bbbbb", null};
		String[] str_output_2 = {"a", "bbb", null};
		MyList<String> a_null = makeList(str_input_2);
		a_null.transformAll(new firstThreeLetterCaseTransformer());
		assertArrayEquals(str_output_2, a_null.toArray());
		
		String[] str_input_3 = {};
		String[] str_output_3 = {};
		MyList<String> empty = makeList(str_input_3);
		empty.transformAll(new firstThreeLetterCaseTransformer());
		assertArrayEquals(str_output_3, empty.toArray());
	}
	
	@Test
	public void testLongWordChooser() {
		String[] str_input_1 = {"longword", "longerword", "short"};
		String[] str_output_1 = {"longword", "longerword"};
		MyList<String> abc = makeList(str_input_1);
		abc.chooseAll(new LongWordChooser());
		assertArrayEquals(str_output_1, abc.toArray());
		
		String[] str_input_2 = {"longword", null, "short"};
		String[] str_output_2 = {"longword"};
		MyList<String> a_null = makeList(str_input_2);
		a_null.chooseAll(new LongWordChooser());
		assertArrayEquals(str_output_2, a_null.toArray());
		
		String[] str_input_3 = {};
		String[] str_output_3 = {};
		MyList<String> empty = makeList(str_input_3);
		empty.chooseAll(new LongWordChooser());
		assertArrayEquals(str_output_3, empty.toArray());
	}
	

}