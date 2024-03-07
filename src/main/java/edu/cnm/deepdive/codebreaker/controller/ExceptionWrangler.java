package edu.cnm.deepdive.codebreaker.controller;

import edu.cnm.deepdive.codebreaker.service.GameCompletedException;
import edu.cnm.deepdive.codebreaker.service.InvalidGuessException;
import edu.cnm.deepdive.codebreaker.service.InvalidPoolException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionWrangler {

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Referenced resource (game or guess) not found.")
  public void notFound() {
  }

  @ExceptionHandler(InvalidPoolException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid pool or characters.")
  public void invalidPool() {
  }

  @ExceptionHandler(InvalidGuessException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid guess length or characters.")
  public void invalidGame() {
  }

  @ExceptionHandler(GameCompletedException.class)
  @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Game already solved.")
  public void gameAlreadySolved() {
  }

}
