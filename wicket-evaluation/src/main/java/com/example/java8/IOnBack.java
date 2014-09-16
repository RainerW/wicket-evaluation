package com.example.java8;

public interface IOnBack<T> extends IActionList
{
  default T onBack(LWicketAction action)
  {
    setAction("onBack", action);
    return (T) this;
  }

  default void actionBack()
  {
    invokeAction("onBack");
  }

  default boolean hasActionBack()
  {
    return getAction("onBack") != null;
  }

}
