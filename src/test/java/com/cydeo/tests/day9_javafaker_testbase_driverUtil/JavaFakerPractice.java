package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){

        //  creating Faker object to reach methods              Faker generates random data
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = "+ faker.name().firstName());    // will generate different name every time run

        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());


        // numerify()  -->               determine the format you want to get the numbers in
        String randomNumber = faker.numerify("###-###-####");
        System.out.println("randomNumber = " + randomNumber);

        System.out.println("faker.numerify(\"708-###-####\") = " + faker.numerify("708-###-####"));


        // letterify() method will return random letters where we pass "?"
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????")); // vzh-ngyj --> every time will print different letters


        // bothify() method will return random letters and numbers
        System.out.println("faker.bothify(\"##?#-##?#-?##?\") = " + faker.bothify("##?#-##?#-?##?"));

                                                                                       // can use any java manipulation method to modify
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-",""));


        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Muhtar"));


        System.out.println("----------------------------------------------");

        Faker faker2 = new Faker(new Locale("pl"));

        System.out.println("faker2.name().fullName() = " + faker2.name().fullName());


    }















}
