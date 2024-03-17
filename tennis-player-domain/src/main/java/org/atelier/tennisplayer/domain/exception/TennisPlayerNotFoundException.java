package org.atelier.tennisplayer.domain.exception;

public class TennisPlayerNotFoundException extends RuntimeException{
    public TennisPlayerNotFoundException(String message) {
        super(message);
    }
}
