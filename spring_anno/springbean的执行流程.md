1、org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons
遍历所有的beanDefinition，判断其是否是非抽象、单例、非懒加载的bean
如果是：
    判断是否是FactoryBean类型
    如果是：
    如果不是：
        调用org.springframework.beans.factory.support.AbstractBeanFactory.getBean(java.lang.String)方法
            调用org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean方法
                1、先从缓存中拿，
                如果拿不到
                    getParentBeanFactory获取父beanFactory，看看该bean父容器中是否有；
                    如果没有：
                        将该bean标记为已创建：
                        
                       