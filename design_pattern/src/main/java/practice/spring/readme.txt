
Spring 提供的观察者模式实现

发布消息通过 ApplicationEventMulticaster 进行，有一个默认实现为：SimpleApplicationEventMulticaster 类：

    @Override
	public void multicastEvent(final ApplicationEvent event, @Nullable ResolvableType eventType) {
		ResolvableType type = (eventType != null ? eventType : resolveDefaultEventType(event));
		Executor executor = getTaskExecutor();
		for (ApplicationListener<?> listener : getApplicationListeners(event, type)) {
			if (executor != null) {
				executor.execute(() -> invokeListener(listener, event));
			}
			else {
				invokeListener(listener, event);
			}
		}
	}

默认 executor 是没有的，所以等同于同步通知，可通过 setTaskExecutor 进行指定
getApplicationListeners 获取指定 event 的 listeners
invokeListener 其实就是调用 listener.onApplicationEvent() 方法



