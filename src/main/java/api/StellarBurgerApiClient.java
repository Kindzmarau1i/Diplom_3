package api;

import api.requests.CreateCustomerRequestDTO;
import api.requests.LoginCustomerRequestDTO;
import api.responses.CreateCustomerResponseDTO;
import api.responses.LoginCustomerResponseDTO;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Класс-реализация методов API сервиса
 */
public class StellarBurgerApiClient implements StellarBurgerApi {

    BaseProvider baseProvider = new BaseProvider();

    @Step("Создать пользователя")
    @Override
    public CreateCustomerResponseDTO createCustomer(CreateCustomerRequestDTO requestBody) {
        return given()
                .spec(baseProvider.getBaseSpec())
                .body(requestBody)
                .post(Endpoints.AUTH_REGISTER)
                .as(CreateCustomerResponseDTO.class);
    }

    @Step("Залогинить пользователя")
    @Override
    public LoginCustomerResponseDTO loginCustomer(LoginCustomerRequestDTO requestBody) {
        return given()
                .spec(baseProvider.getBaseSpec())
                .body(requestBody)
                .post(Endpoints.AUTH_LOGIN)
                .as(LoginCustomerResponseDTO.class);
    }

    @Step("Удалить пользователя")
    @Override
    public void deleteCustomer(String accessToken) {
        given().spec(baseProvider.getBaseSpec())
                .header("authorization", accessToken)
                .delete(Endpoints.AUTH_USER);
    }
}
