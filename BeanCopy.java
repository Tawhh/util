import com.alibaba.tamper.BeanCopy;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * Created by weihh
 */
public class BeanCopierMapper {
    public static Map<String, BeanCopy> beanCopierMap = new HashMap<String, BeanCopy>();


    public static void copyProperties(Object source, Object target) {

        String beanKey = generateKey(source.getClass(), target.getClass());

        BeanCopy copier = null;

        if (!beanCopierMap.containsKey(beanKey)) {

            copier = BeanCopy.create(source.getClass(), target.getClass());

            beanCopierMap.put(beanKey, copier);

        } else {

            copier = beanCopierMap.get(beanKey);

        }

        copier.copy(source, target);

    }

    private static String generateKey(Class<?> class1, Class<?> class2) {

        return class1.toString() + class2.toString();

    }

}
