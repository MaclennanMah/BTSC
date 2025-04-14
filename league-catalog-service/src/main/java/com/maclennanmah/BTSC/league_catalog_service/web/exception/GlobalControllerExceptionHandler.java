package com.maclennanmah.BTSC.league_catalog_service.web.exception;

import com.maclennanmah.BTSC.league_catalog_service.domain.LeagueNotFoundException;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

  private static final String SERVICE_NAME = "league-service";

  @ExceptionHandler(Exception.class)
  ProblemDetail handleUnhandledException(Exception e) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    problemDetail.setTitle("Internal Server Error");
    problemDetail.setProperty("service", SERVICE_NAME);
    problemDetail.setProperty("error_category", "Generic");
    problemDetail.setProperty("timestamp", Instant.now());
    return problemDetail;
  }

  @ExceptionHandler(LeagueNotFoundException.class)
  ProblemDetail handleNoResultException(LeagueNotFoundException e) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    problemDetail.setTitle("Product Not Found");
    problemDetail.setProperty("service", SERVICE_NAME);
    problemDetail.setProperty("error_category", "Generic");
    problemDetail.setProperty("timestamp", Instant.now());
    return problemDetail;
  }
}
