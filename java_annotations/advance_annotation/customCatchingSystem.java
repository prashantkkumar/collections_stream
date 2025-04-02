package java_annotations.advance_annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class CacheHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CacheHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + Arrays.toString(args);
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for: " + key);
                return cache.get(key);
            }
            Object result = method.invoke(target, args);
            cache.put(key, result);
            return result;
        }
        return method.invoke(target, args);
    }
}

interface ExpensiveService {
    @CacheResult
    int compute(int number);
}

class ExpensiveServiceImpl implements ExpensiveService {
    @Override
    public int compute(int number) {
        System.out.println("Computing result for: " + number);
        return number * number;
    }
}

public class customCatchingSystem {
    public static void main(String[] args) {
        ExpensiveService service = (ExpensiveService) Proxy.newProxyInstance(
                ExpensiveService.class.getClassLoader(),
                new Class[]{ExpensiveService.class},
                new CacheHandler(new ExpensiveServiceImpl())
        );

        System.out.println(service.compute(5)); // Computation
        System.out.println(service.compute(5)); // Cached result
        System.out.println(service.compute(10)); // Computation
        System.out.println(service.compute(10)); // Cached result
    }
}
