package com.eduardaliiev.app.autotestdraft;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 11/17/16;
 */
@RunWith(JUnitParamsRunner.class)
@Title("Авторизация через форму логина, чтобы обеспечить безопасность переписки")
@Description("Авторизация по валидным данных пользователя")
public class SignInUserTest extends BaseTest {

    @Test
    @FileParameters("src/main/java/com/eduardaliiev/app/resources/SignIn_info.csv")
    public void SignIn(String login, String password){
        SignInUser enterUser = new SignInUser(driver);
            enterUser
                    .signInEmail(login)
                    .signInPassword(password);
    }
}
