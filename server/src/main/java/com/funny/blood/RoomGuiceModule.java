package com.funny.blood;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public abstract class RoomGuiceModule extends AbstractModule {
  protected void bindSingleton(Class<?> clazz) {
    bind(clazz).in(Singleton.class);
  }

  protected <T> void bindSingleton(Class<T> father, Class<? extends T> son) {
    bind(father).to(son).in(Singleton.class);
  }

  @Override
  protected final void configure() {
    binder().requireExplicitBindings();
    binder().requireExactBindingAnnotations();
    binder().disableCircularProxies();

    bind();
  }

  protected abstract void bind();
}
