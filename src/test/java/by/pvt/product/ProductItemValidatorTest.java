package by.pvt.product;


import by.pvt.pojo.ProductItem;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ProductItemValidatorTest
        extends ScenarioTest<ProductItemValidatorTest.Given,
        ProductItemValidatorTest.When,
        ProductItemValidatorTest.Then> {
    ProductItemValidator productItemValidator;

    @Test
    public void validate() {
        given().newProductItem();
        when().validate(productItemValidator);
        then().noErrors();

    }

    static class Given extends Stage<Given> {
        @ProvidedScenarioState
        ProductItem productItem;

        Given newProductItem() {
            ProductItem productItem = new ProductItem();
            productItem.setPrice(1000.0);
            productItem.setName("Test Product Name");
            return self();
        }
    }

    static class When extends Stage<When> {
        @ExpectedScenarioState
        ProductItem productItem;

        @ProvidedScenarioState
        Errors errors;

        When validate(ProductItemValidator validator){
            errors = new DirectFieldBindingResult(productItem,"productItem");

            validator.validate(productItem, errors);
            return self();
        }

    }

    static class Then extends Stage<Then> {
        @ExpectedScenarioState
        Errors errors;

        Then noErrors(){
            assertFalse(!errors.hasErrors());
            return self();
        }

    }




    @Before
    public void setUp() throws Exception {
        if (productItemValidator == null) {
            productItemValidator = new ProductItemValidator();
        }
    }

    @After
    public void tearDown() throws Exception {
        productItemValidator = null;
    }

    @Test
    public void supports() {
        //given
        Class clazz = ProductItem.class;

        //when
        boolean result = productItemValidator.supports(clazz);

        //then
        assertTrue(result);

    }


}