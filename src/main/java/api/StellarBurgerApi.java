package api;

import api.requests.CreateCustomerRequestDTO;
import api.requests.LoginCustomerRequestDTO;
import api.responses.CreateCustomerResponseDTO;
import api.responses.LoginCustomerResponseDTO;

public interface StellarBurgerApi {

    /**
     * Создать пользователя
     */
    CreateCustomerResponseDTO createCustomer(CreateCustomerRequestDTO requestBody);

    /**
     * Логин пользователя
     */
    LoginCustomerResponseDTO loginCustomer(LoginCustomerRequestDTO requestBody);

    /**
     * Удалить пользователя
     */
    void deleteCustomer(String accessToken);
}
