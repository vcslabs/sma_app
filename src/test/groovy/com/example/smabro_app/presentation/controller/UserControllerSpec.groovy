package com.example.smabro_app.presentation.controller

import com.example.smabro_app.application.facade.UserFacade
import com.example.smabro_app.presentation.controller.api.UserController
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserControllerSpec extends Specification {

    def "helloメソッドテスト"() {
        when:
        def userFacade = Mock(UserFacade)
        def userController = new UserController(userFacade)
        def actual = userController.hello()

        then:
        actual == "hello"
    }

    def "worldメソッドテスト"() {
        when:
        def userFacade = Mock(UserFacade)
        def userController = new UserController(userFacade)
        def actual = userController.world()

        then:
        actual == "world"
    }
}