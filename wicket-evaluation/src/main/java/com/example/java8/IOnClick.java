package com.example.java8;


public interface IOnClick<MY_TYPE> extends IActionList
{
  default MY_TYPE onClick(LWicketAction action)
  {
    setAction("onClick", action);
    return (MY_TYPE) this;
  }

  default void actionClick()
  {
    invokeAction("onClick");
  }
}
