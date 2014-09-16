package com.example.java8;


public interface IOnSaved<T> extends IActionList
{
  default T onSaved(LWicketAction action) {
    setAction("onSaved",action);
    return (T)this;
  }
  
  default void actionSaved() {
    invokeAction("onSaved");
  }

}
