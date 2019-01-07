package com.jk.car.controller;

import com.jk.car.model.CarBean;
import com.jk.car.model.UserBean;
import com.jk.car.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 褚仪明
 * @date: 2019/1/2 11:59
 * @pescription:
 */
@Controller
public class HomeController {

    @Resource
    private HomeService homeService;

/*    @Autowired
    private MongoTemplate mongoTemplate;*/

    /**
     * Description:首页登录
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  23:18
     */
    @RequestMapping("homeLogin")
    @ResponseBody
    public boolean login(String login_code,String phone_number , HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取到验证码
        String code = (String) session.getAttribute("code");
         if (code.equals(login_code)){
             //根据前台传过来手机号查询数据库是否有该手机号
             UserBean userbean = homeService.queryUserPhoneByphone(phone_number);
             if(userbean == null ){
                 homeService.addUserPhone(phone_number);
             }
            return true;
         }else{
             return false;
         }

    }

/**
     * Description:保存预约卖车信息
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  23:18
     */
    @RequestMapping("saveMakeCar")
    @ResponseBody
    public void saveMakeCar(CarBean carBean){

        //用户卖车的汽车信息保存
        homeService.saveMakeCar(carBean);
    }

    /**
     * Description:
     *
     * @param:  * @param null
     * @return: 跳转到首页
     * @auther: cym
     * @date:  20:03
     */
    @RequestMapping("toUser")
    public String toUser(){
        return "showCarList";
    }
    /**
     * Description:
     *
     * @param:  * @param null
     * @return: 跳转到登录
     * @auther: cym
     * @date:  20:03
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }



    /**
     * Description:查询所有车型展示
     *
     * @param:  * @param carBean
     * @return:
     * @auther: cym
     * @date:  19:32
     */
    @RequestMapping("queryCarHome")
    @ResponseBody
    public List<CarBean> queryCarHome(String carType,Integer carBrand) {

        return homeService.queryCarHome(carType,carBrand);
    }

    /**
     * Description: 根据当前汽车id查询该商品说的所有信息 点击进去该商品的详情
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  20:13
     */
    @RequestMapping("queryCarInfoByCarId")
    public String queryCarInfoByCarId(Integer id, Model model) {
        CarBean cars = homeService.queryCarInfoByCarId(id);
        /*System.out.println(cars.toString());*/
        model.addAttribute("cars", cars);
        model.addAttribute("id", id);
        return "carDetails";
    }

    /**
     * Description:查询所有车型展示
     *
     * @param:  * @param carBean
     * @return:
     * @auther: cym
     * @date:  19:32
     */
/*    @RequestMapping("queryCarBrand")
    @ResponseBody
    public List<CarBean> queryCarBrand(Integer carBrand) {

        return homeService.queryCarBrand(carBrand);
    }*/

    /**
         * Description: 跳转到预约
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  15:40
         */

    @RequestMapping("toMake")
    public String toSellCar(){
        return "carMake";
    }
}
