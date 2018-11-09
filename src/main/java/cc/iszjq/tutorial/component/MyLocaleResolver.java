package cc.iszjq.tutorial.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * 可以在链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取链接中信息
        String l = request.getParameter("l");
        //没有就是用默认
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            //以"_"分割获得 语言与区域 例 zh_CN
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
}
