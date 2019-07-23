ThisCrackLicenseId-{
"licenseId":"ThisCrackLicenseId",
"licenseeName":"MykeBai",
"assigneeName":"",
"assigneeEmail":"idea@163.com",
"licenseRestriction":"",
"checkConcurrentUse":false,
"products":[
{"code":"II","paidUpTo":"9999-12-31"},
{"code":"DM","paidUpTo":"9999-12-31"},
{"code":"AC","paidUpTo":"9999-12-31"},
{"code":"RS0","paidUpTo":"9999-12-31"},
{"code":"WS","paidUpTo":"9999-12-31"},
{"code":"DPN","paidUpTo":"9999-12-31"},
{"code":"RC","paidUpTo":"9999-12-31"},
{"code":"PS","paidUpTo":"9999-12-31"},
{"code":"DC","paidUpTo":"9999-12-31"},
{"code":"RM","paidUpTo":"9999-12-31"},
{"code":"CL","paidUpTo":"9999-12-31"},
{"code":"PC","paidUpTo":"9999-12-31"}
],
"hash":"2911276/0",
"gracePeriodDays":7,
"autoProlongated":false}





















public void init(FilterConfig config) throws ServletException {
    try {
        //在过滤器启动时，加载敏感词汇sensitive.txt表，得到敏感词汇集合
        list = new ArrayList<String>();
        //解析sensitive.txt
        String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/sensitive.txt");
        //如果sensitive.txt的字符集是UTF-8，就需要在解析时指定字符集
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null){
            list.add(line);
        }
        reader.close();
        System.out.println(list);
    } catch (Exception e) {
        e.printStackTrace();
    }
}