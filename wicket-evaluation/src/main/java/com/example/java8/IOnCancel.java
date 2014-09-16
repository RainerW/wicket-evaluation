package com.example.java8;


public interface IOnCancel<T> extends IActionList
{
  default T onCancel(LWicketAction action) {
    setAction("onCancel",action);
    return (T)this;
  }
  
  default void actionCancel() {
    invokeAction("onCancel");
  }

}
