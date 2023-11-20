package org.example.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ObservableTest {

    Observable _observable;

    @BeforeEach
    public void setup(){
        _observable = new Observable();
    }

    @Nested
    @DisplayName("Test scenario for getCountWords method")
    class GetCountWords {

        @Test
        @DisplayName("Test case: Method return value correctly")
        public void getCountWordsCorrectly(){
            // given
            var expectedValue = 5;
            // When
            _observable.processString(" CoffEe iS    the    best   drink! ");
            // Then
            assertEquals(expectedValue, _observable.getCountWords());
        }

        @Test
        @DisplayName("Test case: Method return value correctly even with wrong string")
        public void getCountWordsStringWrong(){
            // given
            var expectedValue = 0;
            // When
            _observable.processString(" ***^.;;; ");
            // Then
            assertEquals(expectedValue, _observable.getCountWords());
        }
    }

    @Nested
    @DisplayName("Test scenario for getCountWordsWithEvenCharacters method")
    class GetCountWordsWithEvenCharacters{
        @Test
        @DisplayName("Test case: Method return value correctly")
        public void getCountWordsWithEvenCharactersCorrectly(){
            // given
            var expectedValue = 1;
            // When
            _observable.processString(" JaVa iS    the    best   language ever! ");
            // Then
            assertEquals(expectedValue, _observable.getCountWordsWithEvenCharacters());
        }

        @DisplayName("Test case: Method return value correctly even with wrong string")
        public void getCountWordsWithEvenCharactersStringWrong(){
            // given
            var expectedValue = 0;
            // When
            _observable.processString(" ***^.;;; ");
            // Then
            assertEquals(expectedValue, _observable.getCountWordsWithEvenCharacters());
        }
    }

    @Nested
    @DisplayName("Test scenario for getCountWordsWithUpperAtBegin method")
    class GetCountWordsWithUpperAtBegin{
        @Test
        @DisplayName("Test case: Method return value correctly")
        public void getCountWordsWithUpperAtBeginCorrectly(){
            // given
            var expectedValue = 3;
            // When
            _observable.processString(" JaVaScriPt iS    the    WoRst   lanGuage EVER! ");
            // Then
            assertEquals(expectedValue, _observable.getCountWordsWithUpperAtBegin());
        }

        @Test
        @DisplayName("Test case: Method return value correctly even with wrong string")
        public void getCountWordsWithUpperAtBeginStringWrong(){
            // given
            var expectedValue = 0;
            // When
            _observable.processString(" ***^.;;; ");
            // Then
            assertEquals(expectedValue, _observable.getCountWordsWithUpperAtBegin());
        }
    }

    @Nested
    @DisplayName("Test scenario for registerObserver and unregisterObserver methods")
    class ObserverRegisteringUnregistering{
        @Test
        @DisplayName("Test Case: Registering correctly")
        public void registerObserverCorrectly(){
            // given
            var observer = new Observer(1);
            // When
            _observable.registerObserver(observer);
            // Then
            assertTrue(_observable.getObserverList().size() == 1);
        }

        @Test
        @DisplayName("Test Case: Unregistering correctly")
        public void unregisterObserverCorrectly(){
            // given
            var observer = new Observer(1);
            // When
            _observable.registerObserver(observer);
            _observable.unregisterObserver(observer);
            // Then
            assertTrue(_observable.getObserverList().size() == 0);
        }

        @Test
        @DisplayName("Test Case: Unregistering incorrectly")
        public void unregisterObserverIncorrectly(){
            // given
            var observer = new Observer(1);
            // When / Then
            assertThrows(NoSuchElementException.class, () -> {
                _observable.unregisterObserver(observer);
            });
        }
    }
}