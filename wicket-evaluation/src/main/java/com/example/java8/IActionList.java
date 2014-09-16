package com.example.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public interface IActionList
{
  class Extensions
  {
    private static final WeakHashMap<IActionList, Map<String, LWicketAction>> map = new WeakHashMap<>();
  }

  default void setAction(String id, LWicketAction action)
  {
    Map<String, LWicketAction> actionMap = getActionMap();
    actionMap.put(id, action);
  }

  default Map<String, LWicketAction> getActionMap()
  {
    Map<String, LWicketAction> actionMap = Extensions.map.get(this);
    if (actionMap == null)
    {
      actionMap = new HashMap<>();
      Extensions.map.put(this, actionMap);
    }
    return actionMap;
  }

  default LWicketAction getAction(String id)
  {
    Map<String, LWicketAction> actionMap = getActionMap();
    return actionMap.get(id);
  }

  default void invokeAction(String id)
  {
    LWicketAction action = getAction(id);
    if (action != null)
    {
      action.doAction();
    }
  }
}
