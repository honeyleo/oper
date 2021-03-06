package cn.oper.common.utils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;


/**
 * <pre>
 * 
 *       日期操作
 *      
 *       大家在使用Date对象输出日期字符串表示的时候，大多会遇见一些不算困难的困难。说他不算困难是因为，大家不是不会做，只是一般繁琐的转化工作使人很烦恼，而大多数人不太原意考虑。有些人可能对这方面有所了解，但可能也不够充分，所以我在这里把我所知道的写出来，一来供大家参考，二来也算是抛砖引玉，希望能有更多的人讨论这个话题。
 *       在JAVA中有一个很有用的类：SimpleDateFormat，它使用模板方法以文本形式格式化输出日期对象。一般的用法如下：
 *       SimpleDateFormat f=new SimpleDateFormat(&quot;MMM dd,yyyy&quot;);
 *       f.format(new Date());
 *       
 *       构造SimpleDateFormat使用的字符串就是模扳。这个模扳的表示即
 *       
 *       为&quot;February 21th, 2004&quot;的式样。
 *       其他模扳符号定义为：
 *       符号            意义                      显示形式                       举例
 *       G              公元                        文本                         AD
 *       y              年份                        数字                         2001
 *       M              月                          文本或数字                   July或07
 *       d              日                          数字                        10
 *       h              A.M./P.M.制的钟点（1～12）   数字                         12
 *       H              24小时制的钟点（0～23）      数字                           0
 *       m              分钟                        数字                         30
 *       s              秒                          数字                         43   
 *       S              毫妙                        数字                         234
 *       E              星期几                      文本                         Tuesday
 *       D              一年中的第几天               数字                          360
 *       F              某月中的第几个星期几         数字                          2
 *       w              一年中的第几个星期           数字                           40
 *       W              一个月中的第几个星期         数字                           1
 *       a              A.M./P.M.标记               文本                         PM
 *       k              24小时制的钟点（1～24）      数字                          24
 *       K              A.M./P.M.制的钟点（0～11）   数字                          0
 *       z              时区                        文本                        Eastern
 *       '              转义符                      分隔符        
 *       '             单引号                      符号                        '
 *       
 *       这些符号是可以随意组合的，其中，显示形式为&quot;文本&quot;的符号，使用4个或以上的重复组合将输出长文本字符串，反之输出短字符串。
 *       如：E产生Mon,而EEEE则产生Monday。对于显示形式为&quot;文本和数字&quot;的符号，两次以下包括两次的复用产生数字，而两次以上则产生文本。
 *       另外，字符串模板不单可以在构造函数中使用，更可以在程序中动态的指定、变换。
 * </PRE>
 */

public class DateUtils {
	
	/**
	 * 私有构造，防止外部实例化本类
	 */
	private DateUtils() {
		
	}
	
	/**
	 * Map的Key，用于获取某月第一天{@link #LONGDATE_DATE}格式的日期
	 */
	public static final String START_DATE = "START_DATE";
	
	/**
	 * Map的Key，用于获取某月最后一天{@link #LONGDATE_DATE}格式的日期
	 */
	public static final String STOP_DATE = "STOP_DATE";
	
	/*--------------------------------------------------------------*/
	
	public static String DATE_DATE = "yyyy-M-d";

	public static String DATE_DATEHOUR = "yyyy-M-d H";

	public static String DATE_DATEMINUTE = "yyyy-M-d H:m";

	/**
	 * 一些常用的日期变量定义
	 */
	public static String DATE_DATEMONTH = "yyyy-M";

	public static String DATE_DATETIME = "yyyy-M-d H:m:s";

	public static String LONGDATE_DATE = "yyyy-MM-dd";

	public static String LONGDATE_DATEHOUR = "yyyy-MM-dd HH";

	public static String LONGDATE_DATEMINUTE = "yyyy-MM-dd HH:mm";

	/**
	 * 24小时制时间, 即例如上面的分钟允许为 5, 8, 在此则为 05 08
	 */
	public static String LONGDATE_DATEYEAR = "yyyy";

	public static String LONGDATE_DATEMONTH = "yyyy-MM";

	public static String LONGDATE_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static String LONGDATE_DATETIME2 = "yyyy-MM-dd";
	

	/**
	 * 将 date 由 format1 格式转换到 format2 格式
	 * 
	 * @param date
	 *            要处理的日期(符合 dateformat1格式)
	 * @param dateformat1
	 *            格式1
	 * @param dateformat2
	 *            格式2
	 * @param def
	 *            如果转换出错,返回 def
	 * @return 根据dateformat2格式转换而来的日期字符串
	 */
	public static String changeDate(String date, String dateformat1,
			String dateformat2, String def) {
		String nDate = "";
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					dateformat1);
			java.util.Date d = sdf.parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat(dateformat2);
			nDate = formatter.format(d);
		} catch (Exception e) {
			nDate = def;
		}

		return nDate;
	}

	/**
	 * 根据日期格式取当前日期
	 * 
	 * @param dateformat
	 *            日期格式
	 * @return 日期时间
	 */
	public static String getDate(String dateformat) {
		SimpleDateFormat f = new SimpleDateFormat(dateformat);
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		f.setTimeZone(zone);
		return f.format(new Date());
	}

	/**
	 * 日期相加.<BR>
	 * 
	 * @param datetime
	 *            日期(格式:YYYY-MM-DD)
	 * @param day
	 *            加上N天
	 * @return 相加后的日期YYYY-MM-DD
	 */
	public static String addDate(String datetime, long day) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date1 = formatter.parse(datetime);
			long Time = (date1.getTime() / 1000) + 60 * 60 * day * 24;
			date1.setTime(Time * 1000);
			return formatter.format(date1);
		}

		catch (Exception e) {
		}
		return "";
	}

	/**
	 * 时间相加.<BR>
	 * 
	 * @param datetime
	 *            日期(格式:YYYY-MM-DD HH:MM:SS)
	 * @param minute
	 *            加上N分钟
	 * @return 返回 YYYY-MM-DD HH:MM:SS
	 */
	public static String addTime(String datetime, long minute) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date date1 = formatter.parse(datetime);
			long Time = (date1.getTime() / 1000) + 60 * 30;
			date1.setTime(Time * 1000);
			return formatter.format(date1);
		}

		catch (Exception e) {
		}
		return "";
	}

	/**
	 * 检查日期,不合法反回真
	 * 
	 * @param date
	 * @return boolean 真,假
	 */
	public static boolean checkDate(String date) {
		if (date == null || date == "")
			return true;

		DateFormat fmt = DateFormat.getDateInstance(DateFormat.DEFAULT);
		try {
			fmt.parse(date.trim());
		} catch (ParseException e) {
			return true;
		}
		return false;
	}

	/**
	 * 检查日期是否正确 YYYYMM
	 * 
	 * @param date
	 *            日期
	 */
	public static boolean checkYearMonth(String date) {
		if (date == null || date.equalsIgnoreCase(""))
			return true;
		if (date.length() != 6)
			return true;
		try {
			float f1 = new Float(date).floatValue();
			if (f1 < 195001 || f1 > 210001)
				return true;
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	/**
	 * 根据传入的format格式化日期.<BR>
	 * 
	 * @param datetime
	 *            时期时间
	 * @param format
	 *            日期格式
	 * @return 返回处理后的日期时间字符串
	 */
	public static String FormatDate(String datetime, String format) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			Date date1 = formatter.parse(datetime);
			return formatter.format(date1);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 取当前日期函数 yyyy-MM-dd.<BR>
	 * 
	 * @return 返回当前日期字符串
	 */
	public static String getCurrentDate() {
		return getDate(0);
	}

	/**
	 * 取当前日期时间函数 yyyy-MM-dd HH:mm:ss.<BR>
	 * 
	 * @return 返回当前日期时间字符串
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;
	}
	
	/**
	 * 获取当前北京时间
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	public static String getNowBeiJingTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		URL url;
		String timeStr = "";
		Date date;
		try {
			url = new URL("http://www.bjtime.cn");
			URLConnection uc = url.openConnection();
			uc.connect();
			long ld = uc.getDate(); // 取得网站日期时间
			date = new Date(ld); // 转换为标准时间对象
			timeStr = formatter.format(date);
		} catch (IOException e) {
			date = new Date(System.currentTimeMillis());
			timeStr = formatter.format(date);
		} finally {
			return timeStr;
		}
	}
	
	/**
	 * 取当前时间函数 HH:mm:ss.<BR>
	 * 
	 * @return 返回当前时间字符串
	 */
	public static String getCurrentTime() {
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;
	}

	/**
	 * 取当前时间函数 HH:mm:ss.<BR>
	 * 
	 * @return 返回当前时间字符串
	 */
	public static String getCurrentTimeGMT() {
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		String d = f.format(new Date());
		return d;
	}

	/**
	 * @函数名称：getCurrentDateStr
	 * @创建日期：2009-7-31
	 * @功能说明：得到
	 * @参数说明：
	 * @返回说明：
	 */
	public static String getCurrentDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;
	}

	/**
	 * @函数名称：getCurrentTimeStr
	 * @创建日期：2009-7-31
	 * @功能说明：得到格式为“yyyyMMddHHmmss”的日期时间
	 * @参数说明：
	 * @返回说明：
	 */
	public static String getCurrentTimeStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;
	}

	/**
	 * @函数名称：getCurrentTimeStrAll
	 * @创建日期：2009-7-31
	 * @功能说明：得到格式为“yyyyMMddHHmmssSSS”的GMT+8时区的当前日期时间
	 * @参数说明：
	 * @返回说明：
	 */
	public static String getCurrentTimeStrAll() {
		SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmssSSS");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");//
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;
	}

	/**
	 * @函数名称：getCurrentTimeStrAllGMT
	 * @创建日期：2009-7-31
	 * @功能说明：得到格式为“yyyyMMddHHmmssSSS”的GMT时区的当前日期时间
	 * @参数说明：
	 * @返回说明：
	 */
	public static String getCurrentTimeStrAllGMT() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		TimeZone zone = TimeZone.getTimeZone("GMT");// +8
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;
	}

	/**
	 * @return
	 * @函数名称：getDate
	 * @创建日期：2008-8-1
	 * @功能说明：
	 * @参数说明：dayCount long 当前天的前面第几天
	 * @返回说明：指定日期字符串
	 */
	public static String getDate(long dayCount) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		formatter.setTimeZone(zone);

		java.util.Date myDate = new java.util.Date();
		try {
			long myTime = (myDate.getTime() / 1000) + 60 * 60 * dayCount * 24;
			myDate.setTime(myTime * 1000);
		} catch (Exception e) {
			
		}
		return formatter.format(myDate);
	}
	
	public static String getDate2(long dayCount,String datatime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		formatter.setTimeZone(zone);

		DateFormat d=DateFormat.getDateInstance();
		Date date= d.parse(datatime);
		try {
			long myTime = (date.getTime() / 1000) + 60 * 60 * dayCount * 24;
			date.setTime(myTime * 1000);
		} catch (Exception e) {
		}
		return formatter.format(date);
	}
	/**
	 * @函数名称：getDate
	 * @创建日期：2008-8-1
	 * @功能说明：得到参考日期的过去或者将来的日期
	 * @参数说明： dateTime String 参考日期 <BR>
	 *        dayCount int 过去或者将来日期的周期数（正数表示将来，负数表示过去） <BR>
	 *        dayType String 周期性（YEAR-年，MONTH-月，DAY-日，HOUR－时，MINUTE－分，SECOND－秒）
	 * @返回说明：
	 */
	public static String getDate(String dateTime, int periodCount,
			String dayType) {
		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone("GMT+8"));

		calendar.setTime(strToDate(dateTime, LONGDATE_DATETIME));

		String formatStr = "";
		if (dayType.equals("YEAR")) {// 如果周期是“年”
			calendar.add(Calendar.YEAR, periodCount);
			formatStr = LONGDATE_DATEYEAR;
		} else if (dayType.equals("MONTH")) {// 如果周期是“月”
			calendar.add(Calendar.MONTH, periodCount);
			formatStr = LONGDATE_DATEMONTH;
		} else if (dayType.equals("DAY")) {// 如果周期是“日”
			calendar.add(Calendar.DAY_OF_MONTH, periodCount);
			formatStr = LONGDATE_DATE;
		} else if (dayType.equals("HOUR")) {// 如果周期是“时”
			calendar.add(Calendar.HOUR, periodCount);
			formatStr = LONGDATE_DATEHOUR;
		} else if (dayType.equals("MINUTE")) {// 如果周期是“分”
			calendar.add(Calendar.MINUTE, periodCount);
			formatStr = LONGDATE_DATEMINUTE;
		} else if (dayType.equals("SECOND")) {// 如果周期是“秒”
			calendar.add(Calendar.SECOND, periodCount);
			formatStr = LONGDATE_DATETIME;
		}

		Date date = calendar.getTime();
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		String dateStr = df.format(date);

		return dateStr;
	}

	/**
	 * 取一个yyyy-mm-dd日期的日
	 * 
	 * @param date
	 *            yyyy-mm-dd
	 * @return 2位日期或者""
	 */
	public static String getDateDay(String date) {
		String str = "";
		try {
			str = date.substring(8, 10);
		} catch (Exception e) {
		}
		return str;
	}

	/**
	 * 取一个yyyy-mm-dd日期的月
	 * 
	 * @param date
	 *            yyyy-mm-dd
	 * @return 2位月或者""
	 */
	public static String getDateMonth(String date) {
		String str = "";
		try {
			str = date.substring(5, 7);
		} catch (Exception e) {
		}
		return str;
	}

	/**
	 * 取当前日期时间
	 * 
	 * @return 日期时间 yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		f.setTimeZone(zone);
		String d = f.format(new Date());
		return d;

	}

	/**
	 * 取当前日期时间
	 * 
	 * @param d_type
	 *            1/取-号分隔的日期 2/取:号分隔的日期 3/取-及:分隔的日期时间
	 * @return 日期时间 yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime(int d_type) {

		String DateTime = "";
		Calendar now = new GregorianCalendar();
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH) + 1;
		int d = now.get(Calendar.DAY_OF_MONTH);
		int h = now.get(Calendar.HOUR_OF_DAY);
		int mi = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);

		String vm = m < 10 ? "0" + m : "" + m;
		String vd = d < 10 ? "0" + d : "" + d;
		String vh = d < 10 ? "0" + h : "" + h;
		String vmi = mi < 10 ? "0" + mi : "" + mi;
		String vs = s < 10 ? "0" + s : "" + s;

		if (d_type == 1) {
			DateTime = DateTime + y + "-"; // yeah
			DateTime = DateTime + vm + "-"; // month
			DateTime = DateTime + vd; // day
		} else if (d_type == 2) {
			DateTime = DateTime + vh + ":"; // hour
			DateTime = DateTime + vmi + ":"; // minute
			DateTime = DateTime + vs; // second
		} else if (d_type == 3) {
			DateTime = DateTime + y + "-"; // yeah
			DateTime = DateTime + vm + "-"; // month
			DateTime = DateTime + vd + " "; // day
			DateTime = DateTime + vh + ":"; // hour
			DateTime = DateTime + vmi + ":"; // minute
			DateTime = DateTime + vs; // second
		}
		return DateTime;

	}

	/**
	 * 取一个yyyy-mm-dd日期的年
	 * 
	 * @param date
	 *            yyyy-mm-dd
	 * @return 4位年或者""
	 */
	public static String getDateYear(String date) {
		String str = "";
		try {
			str = date.substring(0, 4);
		} catch (Exception e) {
		}
		return str;
	}

	/**
	 * 检查两个日期是否在同一个月里面
	 * @param date1
	 * @param date2
	 * @return	是同一个月返回:true 否则返回:false
	 */
	public static boolean checkDateWithMonth(String date1, String date2){
		String month1 = getDateMonth(date1);
		String month2 = getDateMonth(date2);
		if(!("").equals(month1) && month1.equals(month2)){
			return true;
		}
		return false;
	}
	
	/**
	 * 功能：查询这个月的天数
	 * @param date	日期
	 * @return		返回这个月共有多少天,也就是最后 一天
	 */
	@SuppressWarnings("static-access")
	public static int getMonthLastDay(String date){
		int day = 0;
		Date date1 = strToDate(date, "yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date1);
		//java中jan(一月)是0,所以这里加上2,向后推一个月
		calendar.add(calendar.MONTH, 2);
		//设置日期为1号
		calendar.set(calendar.DATE, 1);
		calendar.add(calendar.DAY_OF_MONTH, -1);
		date1 = calendar.getTime();
		String dateStr = getDataFormString(date1, "yyyy-MM-dd");
		day = Integer.valueOf(getDateDay(dateStr).toString());
		return day;
	}
	
	/**
	 * 取两个日期之间的天数.<BR>
	 * 参数格式为 yyyy-mm-dd 例如 date1 = 2002-12-11, date2 = 2002-12-13, 返回 2 例如 date1
	 * = 2002-12-13, date2 = 2002-12-11, 返回 -2
	 * 
	 * @param date1
	 *            日期一
	 * @param date2
	 *            日期二
	 * @return 整数,相差天数
	 */
	public static long getDiffDate(String date1, String date2) {

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date = myFormatter.parse(date2);
			java.util.Date mydate = myFormatter.parse(date1);
			long day = (date.getTime() - mydate.getTime())
					/ (24 * 60 * 60 * 1000);
			return day;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 取两个日期时间之间相隔的分钟数.<BR>
	 * 参数格式为 yyyy-MM-dd HH:mm:ss<BR>
	 * 例如 date1 = 2002-12-12 22:22:00, date2 = 2002-12-12 22:23:00, 返回 1<BR>
	 * 例如 date1 = 2002-12-12 22:23:00, date2 = 2002-12-12 22:22:00, 返回 -1<BR>
	 * 
	 * @param datetime1
	 *            日期时间一
	 * @param datetime2
	 *            日期时间二
	 * @return 整数,相差分钟数
	 */
	public static long getDiffMinute(String datetime1, String datetime2) {

		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date date = myFormatter.parse(datetime2);
			java.util.Date mydate = myFormatter.parse(datetime1);
			long day = (date.getTime() - mydate.getTime()) / (1000 * 60);
			return day;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 取两个日期时间之间相隔的秒数.<BR>
	 * 参数格式为 yyyy-MM-dd HH:mm:ss<BR>
	 * 例如 date1 = 2002-12-12 22:22:22, date2 = 2002-12-12 22:22:23, 返回 1<BR>
	 * 例如 date1 = 2002-12-12 22:22:23, date2 = 2002-12-12 22:22:22, 返回 -1<BR>
	 * 
	 * @param datetime1
	 *            日期时间一
	 * @param datetime2
	 *            日期时间二
	 * @return 整数,相差分钟数
	 */
	public static long getDiffSecond(String datetime1, String datetime2) {

		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date date = myFormatter.parse(datetime2);
			java.util.Date mydate = myFormatter.parse(datetime1);
			long day = (date.getTime() - mydate.getTime()) / 1000;
			return day;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 按提供的格式取当前日期.<BR>
	 * 
	 * @param get_format
	 *            日期格式
	 * @return 按格式返回的日期
	 */
	public static String getNowDate(String get_format) {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(get_format);
		TimeZone zone = TimeZone.getTimeZone("GMT+8");
		sf.setTimeZone(zone);
		String temp = sf.format(date);

		return temp;
	}

	/**
	 * 取当前周数<BR>
	 * .
	 * 
	 * @param type
	 *            1/取本天是一周的第几天 2/取本周是月的第几周 3/取本周是一年的第几周
	 * @return 日期时间 yyyy-MM-dd HH:mm:ss
	 */
	public static int getWeek(int type) {
		java.util.Calendar calendar = new java.util.GregorianCalendar();
		int dWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int mWeek = calendar.get(Calendar.WEEK_OF_MONTH);
		int yWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		int theWeek = 0;
		if (type == 1) {
			theWeek = dWeek;
		} else if (type == 2) {
			theWeek = mWeek;
		} else if (type == 3) {
			theWeek = yWeek;
		}
		return theWeek;
	}

	/**
	 * 功能：将Date型日期转换成指定默认格式字符型日期
	 * @param date			date日期
	 * @return				返回默认格式字符型日期
	 */
	public static String getDataFormString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datastring = format.format(date);
		return datastring;
	}
	
	/**
	 * 功能：将Date型日期转换成指定格式的字符串型日期
	 * @param date			date日期
	 * @param formatStr		要转换的日期格式
	 * @return				返回指定格式字符型日期
	 */
	public static String getDataFormString(Date date, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		String datastring = format.format(date);
		return datastring;
	}

	public static String getDataFormString(Object date) {
		String datastring = "";
		if (null != date) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			datastring = format.format(date);
		}
		return datastring;
	}

	public static Date getStringFormData(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = format.parse(date);
		return d;
	}
	
	/**
	 * 功能：将字符串型日期转换为指定格式的Date型日期
	 * @param date		日期
	 * @param formats	格式
	 * @return
	 * @throws ParseException
	 */
	public static Date getStringFormData(String date,String formats) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(formats);
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 是否为正确的日期.<BR>
	 * strDate "YYYY-MM-DD" 或者 "YYYY/MM/DD"<BR>
	 * allowNull 是否允许为空<BR>
	 * 
	 * @param strDate
	 * @param allowNull
	 * @return 真或者假
	 */
	public static boolean isDate(String strDate, boolean allowNull) {
		int intY, intM, intD;
		int[] standardDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] leapyearDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (strDate == null || strDate.trim().equals(""))
			return true;

		if (strDate.trim().length() != 10)
			return false;
		strDate = strDate.trim();
		try {
			intY = Integer.parseInt(strDate.substring(0, 4));
			intM = Integer.parseInt(strDate.substring(5, 7));
			intD = Integer.parseInt(strDate.substring(8));
		} catch (Exception e) {
			return false;
		}
		if (intM > 12 || intM < 1 || intY < 1 || intD < 1)
			return false;
		if ((intY % 4 == 0 && intY % 100 != 0) || intY % 400 == 0)
			return (intD <= leapyearDays[intM - 1]);
		return (intD <= standardDays[intM - 1]);
	}

	/**
	 * 功能：将字符串型日期转换为指定格式的Date型日期
	 * 
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 */
	public static Date strToDate(String dateStr, String dateFormat) {
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(dateFormat);

		try {
			date = myFormatter.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 功能：将字符串型日期转换为Date型日期(yyyy-MM-dd HH:mm:SS)
	 * 
	 * @param dateStr
	 *            String 字符串型日期
	 * @return Date
	 */
	public static Date strToLongDate(String dateStr) {
		return strToDate(dateStr, LONGDATE_DATETIME2);
	}

	public static java.sql.Date getSqlDate(Object obj) throws ParseException {

		DateFormat d = DateFormat.getDateInstance();
		String datestring = d.format(obj);
		Date date = d.parse(datestring);
		return new java.sql.Date(date.getTime());
	}

	public static String getStartDate() {
		String startdate = "";
		Date date = new Date();
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM");
		startdate = data.format(date);
		startdate = startdate.replace("-", "");
		return startdate;
	}

	/**
	 * 功能：将给定字符型日期转换成 yyyyMM 格式的字符串
	 * @param date	字符型日期
	 * @return		yyyyMM格式的字符串
	 */
	public static String getStartDate(String date) {
		String startdate = "";
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM");
		try {
			Date tempdate = data.parse(date);
			startdate = data.format(tempdate);
			startdate = startdate.replace("-", "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startdate;
	}
	
	/**
	 * 取得两个日期区间的所有{@link DateUtils#LONGDATE_DATE}格式的日期<br>
	 * 
	 * 分别将区间内的日期存储到{@link List}集合中返回
	 * 
	 * @author lvkun 2013-03-12
	 * 
	 * {@link DataEnteringService#getDateIntervalDataJSONArray(String, String, String, String)}
	 * 
	 * @param startDate
	 * @param stopDate
	 * @return
	 */
	public static List<String> getDateList(String startDate, String stopDate) {
		DateFormat formater = new SimpleDateFormat(LONGDATE_DATE);
		Calendar start = Calendar.getInstance();
		Calendar stop = Calendar.getInstance();
		try {
			start.setTime(formater.parse(startDate));
			stop.setTime(formater.parse(stopDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> dateList = new ArrayList<String>();
		while (start.compareTo(stop) <= 0) {
			String tempDate = formater.format(start.getTime());
			
			dateList.add(tempDate);
			
			start.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return dateList;
	}
	
	/**
	 * 获取当前日期的中文星期
	 * 
	 * @return
	 */
	public static String getZHCNWeekDay() {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (week < 0) {
			week = 0;
		}
		
		return weekDays[week];
	}
	
	/**
	 * 获得某个月对应{@link #LONGDATE_DATEMONTH}格式的日期
	 * 
	 * @param amount
	 * @return
	 */
	public static String getYearMonthByAmount(int amount) {
		DateFormat df = new SimpleDateFormat(LONGDATE_DATEMONTH);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, amount);

		return df.format(calendar.getTime());
	}

	/**
	 * 获得指定年月日期的月份第一天和最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Map<String, String> getStratDateAndStopDate(int year, int month) {
		DateFormat df = new SimpleDateFormat(LONGDATE_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		// month从0开始，因此需要把当前传递的month-1
		int iMonth = month - 1;
		calendar.set(Calendar.MONTH, iMonth);
		
		int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		calendar.set(year, iMonth, minDay);
		String startDate = df.format(calendar.getTime());
		calendar.set(year, iMonth, maxDay);
		String stopDate = df.format(calendar.getTime());
		
		Map<String, String> date = new HashMap<String, String>();
		date.put(START_DATE, startDate);
		date.put(STOP_DATE, stopDate);
		
		return date;
	}
}