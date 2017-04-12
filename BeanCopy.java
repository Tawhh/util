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

/**
	 * 百分比计算
	 * @param y
	 * @param z
     * @return
     */
	public static String myPercent(int y, int z) {
		double yy=y*1.0;
		double xx=z*1.0;
		double percent = 0 ;
		if (xx!=0){
			 percent = yy / xx;
		}
		NumberFormat nt = NumberFormat.getPercentInstance();
		nt.setMinimumFractionDigits(2);
		return nt.format(percent);
	}

/**
	 * 转ajax请求json数据
	 * @param jsonOb
	 * @param response
     */
	public static void printJsonForJSONP(JSONObject jsonOb, HttpServletResponse response)
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		try
		{
			response.getWriter().write(JSON.toJSONString(jsonOb, new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse }));
			response.getWriter().flush();
			response.getWriter().close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
