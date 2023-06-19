package com.kata.kataforfunjava.services;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class KataForFunServiceTest {

    @InjectMocks
    private KataForFunService kataForFunService;

    @Test
    void should_return_input_if_no_match() {
        assertThat(kataForFunService.convertNumber(1)).isEqualTo("1");
    }

    @Nested
    class ShouldReplaceNumberWithKata {
        @Test
        void should_replace_with_Kata_if_number_is_divisible_by_3() {
            assertThat(kataForFunService.convertNumber(9)).isEqualTo("Kata");
            assertThat(kataForFunService.convertNumber(6)).isEqualTo("Kata");
            assertThat(kataForFunService.convertNumber(12)).isEqualTo("Kata");
        }

        @Test
        void should_replace_with_Kata_if_number_contains_3() {
            assertThat(kataForFunService.convertNumber(3)).isEqualTo("KataKata");
            assertThat(kataForFunService.convertNumber(333)).isEqualTo("KataKataKataKata");
        }
    }

    @Nested
    class ShouldReplaceNumberWithFor {
        @Test
        void should_replace_with_For_if_number_is_divisible_by_5() {
            assertThat(kataForFunService.convertNumber(10)).isEqualTo("For");
            assertThat(kataForFunService.convertNumber(20)).isEqualTo("For");
        }

        @Test
        void should_replace_with_For_if_number_contains_5() {
            assertThat(kataForFunService.convertNumber(5)).isEqualTo("ForFor");
            assertThat(kataForFunService.convertNumber(55)).isEqualTo("ForForFor");
        }
    }

    @Nested
    class ShouldReplaceNumberWithFun {
        @Test
        void should_not_replace_with_Fun_if_number_is_divisible_by_7() {
            assertThat(kataForFunService.convertNumber(14)).isEqualTo("14");
            assertThat(kataForFunService.convertNumber(28)).isEqualTo("28");
        }

        @Test
        void should_replace_with_Fun_if_number_contains_7() {
            assertThat(kataForFunService.convertNumber(7)).isEqualTo("Fun");
            assertThat(kataForFunService.convertNumber(77)).isEqualTo("FunFun");
        }
    }

    @Nested
    class ShouldReplaceNumberWithKataFor {
        @Test
        void number_is_divisible_by_3_and_by_5() {
            assertThat(kataForFunService.convertNumber(60)).isEqualTo("KataFor");
        }

        @Test
        void number_is_divisible_by_3_and_by_5_and_contains_them() {
            assertThat(kataForFunService.convertNumber(15)).isEqualTo("KataForFor");
            assertThat(kataForFunService.convertNumber(30)).isEqualTo("KataForKata");
            assertThat(kataForFunService.convertNumber(315)).isEqualTo("KataForKataFor");
        }
    }

    @Nested
    class ShouldReplaceNumberWithKataFun {
        @Test
        void number_is_divisible_by_3_and_by_7() {
            assertThat(kataForFunService.convertNumber(21)).isEqualTo("Kata");
        }

        @Test
        void number_is_divisible_by_3_and_contains_7_and_3() {
            assertThat(kataForFunService.convertNumber(729)).isEqualTo("KataFun");
            assertThat(kataForFunService.convertNumber(14348907)).isEqualTo("KataKataFun");
        }
    }

    @Nested
    class ShouldReplaceNumberWithForFun {
        @Test
        void number_is_divisible_by_5_and_by_7() {
            assertThat(kataForFunService.convertNumber(140)).isEqualTo("For");
        }

        @Test
        void number_is_divisible_by_5_and_contains_7_and_5() {
            assertThat(kataForFunService.convertNumber(175)).isEqualTo("ForFunFor");
        }
    }

    @Nested
    class ShouldReplaceNumberWithKataForFun {
        @Test
        void number_is_divisible_by_5_and_7_and_3() {
            assertThat(kataForFunService.convertNumber(105)).isEqualTo("KataForFor");
        }

        @Test
        void number_is_divisible_by_5_and_3_and_contains_3_7_and_5() {
            assertThat(kataForFunService.convertNumber(885735)).isEqualTo("KataForForFunKataFor");
        }
    }
}
