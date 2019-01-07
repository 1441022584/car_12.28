package com.jk.car.controller;

import com.jk.car.model.BuyCarBean;
import com.jk.car.model.UserBean;
import com.jk.car.service.BuyCarService;
import com.jk.car.utils.JsonUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 方法实现说明
 *
 * @author 王垚
 * <p>
 * $
 * @return $
 * @exception
 * @date $ $
 */
@Controller
public class BuyCarController {

    @Resource
    private BuyCarService buyCarService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 这是跳转预约弹框页面
     * @return
     */
    @RequestMapping("toModalMake")
    public String toModalMake(){

        return "modalMake";

    }

    /**
     * 这是跳转买车页面
     * @return
     */
    @RequestMapping("toBuyCar")
    public String toBuyCar(){
        return "buycar";
    }
    /**
     * 这是跳转买车页面购买
     * @return
     */
    @RequestMapping("toBuyCars")
    public String toBuyCars(){
        return "buyCars";
    }

    /**
     * 查询买车列表
     * @return
     */
    @RequestMapping("getBuyCarList")
    @ResponseBody
    public List<BuyCarBean> getBuyCarList(BuyCarBean buyCarBean){
            List<BuyCarBean> buyCarBeanList=  buyCarService.getBuyCarList(buyCarBean);
            return buyCarBeanList;

    }

    /**
     * 回显地址和id字段
     */
    @RequestMapping("getBuyCarListById")
    @ResponseBody
    public BuyCarBean getBuyCarListById(BuyCarBean buyCarBean){
        BuyCarBean buyCarById=buyCarService.getBuyCarListById(buyCarBean);
        return buyCarById;
    }

    /**
     * 预约看车提交给管理员审批
     */
    @RequestMapping("addBuyCarStatus")
    @ResponseBody
    public void addBuyCarStatus(BuyCarBean buyCarBean1, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserBean userId = (UserBean) session.getAttribute(session.getId());
        Integer id = userId.getId();
        BuyCarBean buyCarBean = new BuyCarBean();

        buyCarBean.setCarStatus(3);

        buyCarBean.setCartype(buyCarBean1.getCartype());

        buyCarBean.setCarage(buyCarBean1.getCarage());

        buyCarBean.setCarDemand(buyCarBean1.getCarDemand());

        buyCarBean.setCarDetails(buyCarBean1.getCarDetails());

        buyCarBean.setCarDisplacement(buyCarBean1.getCarDisplacement());

        buyCarBean.setCarImg(buyCarBean1.getCarImg());

        buyCarBean.setCarLicencesto(buyCarBean1.getCarLicencesto());

        buyCarBean.setCarLicenseMonth(buyCarBean1.getCarLicenseMonth());

        buyCarBean.setCarLicenseplatenumber(buyCarBean1.getCarLicenseplatenumber());

        buyCarBean.setCarMonthString(buyCarBean1.getCarMonthString());

        buyCarBean.setCarParameter(buyCarBean1.getCarParameter());

        buyCarBean.setCarpart(buyCarBean1.getCarpart());

        buyCarBean.setCarPrice(buyCarBean1.getCarPrice());

        buyCarBean.setCarRoadroller(buyCarBean1.getCarRoadroller());

        buyCarBean.setCarseat(buyCarBean1.getCarseat());

        buyCarBean.setCarSeries(buyCarBean1.getCarSeries());

        buyCarBean.setCarshift(buyCarBean1.getCarshift());

        buyCarBean.setCarSite(buyCarBean1.getCarSite());

        buyCarBean.setUserId(id);

        buyCarBean.setCarVehiclecondition(buyCarBean1.getCarVehiclecondition());

        buyCarBean.setCarTime(buyCarBean1.getCarTime());

        buyCarBean.setCarYearString(buyCarBean1.getCarYearString());

        buyCarBean.setMileage(buyCarBean1.getMileage());

        buyCarService.addBuyCarStatus(buyCarBean);

        String s = JsonUtils.objectToJson(buyCarBean);

        amqpTemplate.convertAndSend("addBuyCarWY",s);
    }
    /**
     * 买车首页Highchars根据年
     */
    @RequestMapping("getBuyCarHighcharsYear")
    @ResponseBody
    public List<Map<String,Object>> getBuyCarHighcharsYear(){
        List<Map<String, Object>> list = new ArrayList<>();
        List<Map<String, Object>> yearList= buyCarService.getBuyCarHighcharsYear();
        for (Map<String, Object> map :yearList) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("y",map.get("总个数"));
            map1.put("n",map.get("年"));
            map1.put("sliced", false);
            map1.put("selected", false);
            list.add(map1);
        }
        return list;
    }
    /**
     * 单个查询列表
     * @return
     */
    @RequestMapping("getBuyCarListOne")
    public String getBuyCarListOne(Integer id, Model model){
        BuyCarBean buyCarOne=  buyCarService.getBuyCarListOne(id);
        System.out.println(buyCarOne);
        model.addAttribute("buyCarOne",buyCarOne);
        model.addAttribute("id",id);
        return "buyCars";
    }
    /**
     * 查询列表总条数
     * @return
     */
    @RequestMapping("getBuyCarListCount")
    public String getBuyCarListCount(Model model){
        int count=  buyCarService.getBuyCarListCount();
        System.out.println(count);
        model.addAttribute("count",count);
        return "buyCar";
    }

    /**
     * 大数据导出
     * @param response
     * @throws Exception
     *//*
    @RequestMapping("downExcel")
    public void downExcel(final HttpServletResponse response) throws Exception{
        //1.查询数据库的数据总条数
        Long count=buyCarService.queryCountList();
        System.out.println(count);
        //分页展示
        Long totalpage =count%1000==0?count/1000:count/1000+1;
        System.out.println(totalpage);
        //定义workbook对象
        final XSSFWorkbook xssfWrkBook =new XSSFWorkbook();
        //定义单列线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //循环页数  有多少页就创建多少线程
        for (int i = 1; i <= totalpage; i++) {
            final int  a= i;
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    //查询数据  分页查询
                    PagerEntity page =new PagerEntity(a,1000);
                    Map map =new HashMap();
                    map.put("page", page.getStart());
                    map.put("rows",page.getPageSize());

                    //标题
                    String title ="用户列表";
                    //列头
                    String[] rowName = {"ID","类型"};
                    //分页查询
                    List<BuyCarBean> list = new ArrayList<BuyCarBean>();
                    try {
                        list =buyCarService.findUserList(map);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //创建list接收传递的数据
                    List<Object[]>  dataList =new ArrayList<Object[]>();
                    Object[] obj=null;
                    //循环遍历查询的数据然后把数据放到新的list集合中
                    for (BuyCarBean map1 : list) {
                        //创建出序列的长度的object数组
                        obj = new Object[rowName.length];
                        obj[0]=map1.getId();
                        obj[1]=map1.getCartype();
                        dataList.add(obj);
                    }

                    ExportExcelMax exc =new ExportExcelMax(xssfWrkBook, title, rowName, dataList, response);
                    try {
                        exc.export(a);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            });
            //6线程池停止

        }
        executor.shutdown();
        while(true){
            //7.
            if(executor.isTerminated()){
                String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xlsx";
                String headStr = "attachment; filename=\"" + fileName + "\"";
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setHeader("Content-Disposition", headStr);
                OutputStream out = response.getOutputStream();
                xssfWrkBook.write(out);
                ///8.
                break;
            }
            //9.
            Thread.sleep(100);
        }
    }
    *//**
     * 大数据导入
     *//*
    @RequestMapping("importExcel")
    public void importExcel(MultipartFile file, HttpServletRequest request){
        //获得上传文件上传的类型
        String contentType = file.getContentType();
        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //获得文件的后缀名
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        //上传文件的新的路径
        //生成新的文件名称
        String filePath = "../src/main/resources/templates/imgupload/";

        //1.查询数据库的数据总条数
        Long count=buyCarService.queryCountList();

        //创建list集合接收excel中读取的数据
        List<BuyCarBean> list =new ArrayList<BuyCarBean>();
        try {
            uploadFile(file.getBytes(), filePath, fileName);
            if(fileType.equals(".xls")){
            }else if(fileType.equals(".xlsx")){
                //通过上传的文件创建workbook对象
                FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
                //通过workbook对象获得sheet的集合循环遍历
                for(int i=0;i<workbook.getNumberOfSheets();i++){
                    //获得其中每一个sheet页
                    XSSFSheet sheetAt = workbook.getSheetAt(i);
                    //获得每一行以后循环遍历列
                    for (int j = 3; j < sheetAt.getPhysicalNumberOfRows(); j++) {
                        //通过行获得每一列
                        XSSFRow row = sheetAt.getRow(j);
                        //获得表格的每一列后需要把获得值放到对象
                        BuyCarBean user=new BuyCarBean();
                        //判断是否为空
                        if(!"".equals(row.getCell(1)) && row.getCell(1)!=null){
                            user.setCartype(this.getCellValue(row.getCell(1)));
                        }

                        //把book对象放到list集合中去
                        list.add(user);
                    }
                }

                //定义单列线程池
                ExecutorService pool = Executors.newFixedThreadPool(50);
                pool.execute(new Runnable() {

                    @Override
                    public void run() {
                        //新增数据
                        buyCarService.insertMany(list);

                    }
                });

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(XSSFCell cell){
        String value = null;
        //简单的查检列类型
        switch(cell.getCellType())
        {
            case XSSFCell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC://数字
                long dd = (long)cell.getNumericCellValue();
                value = dd+"";
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                value = "";
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }


    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }*/


}
