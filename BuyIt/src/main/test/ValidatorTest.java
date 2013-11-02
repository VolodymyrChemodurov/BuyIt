import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.lab.buyit.controller.setters.UserSetter;
import com.epam.lab.buyit.controller.validator.Validator;

public class ValidatorTest {

	@Test
	public void testGetValidator (){
		assertNotNull(Validator.getValidator(UserSetter.FIRST_NAME.getField()));
	}
	
	
}
