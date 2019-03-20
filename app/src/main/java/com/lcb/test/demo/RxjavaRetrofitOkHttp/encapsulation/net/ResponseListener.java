/**
 * 
 */
package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.net;

public interface ResponseListener<T> {

	void onResponse(T response);

	void onErrorResponse(Throwable error);

}
