package com.eljhoset.share.domain.exception;

/**
 *
 * @author jd-jd
 */
public class NegativeMoneyException extends RuntimeException {

    public NegativeMoneyException(String message) {
        super(message);
    }

}
