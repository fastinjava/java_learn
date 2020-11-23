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
                    如果没有(只能自己创建了)：
                        将该bean标记为已创建：(防止自己创建的时候别的地方再去创建)
                        org.springframework.beans.factory.support.AbstractBeanFactory#getMergedLocalBeanDefinition
                        org.springframework.beans.factory.support.AbstractBeanFactory#checkMergedBeanDefinition
                        mbd.getDependsOn()：获取所有的依赖对象
                        遍历所有的依赖对象，并创建依赖对象；
                        mbd：判断是否是单例对象
                        org.springframework.beans.factory.support.DefaultSingletonBeanRegistry#getSingleton(java.lang.String, org.springframework.beans.factory.ObjectFactory<?>)：从缓存中拿，拿不到则使用ObjectFactory的getObject中的createBean方法
                        mbdToUse.prepareMethodOverrides()；
                        org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean方法；
                        
                        
                       