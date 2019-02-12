package com.wuxin.tong.scala.Controller


import com.wuxin.tong.service.service.TableStatisticStatusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, ResponseBody}

@Controller
@RequestMapping(Array("/test01"))
class test01 @Autowired()(val tableStatisticStatusService:TableStatisticStatusService){


  @RequestMapping(Array("/test"))
  def test() = "redirect:status?id=5"

  /**
    *
    * @param id
    * @return
    */
  @RequestMapping(Array("/status"))
  @ResponseBody
  def status(@RequestParam(value = "id")id: Long)= tableStatisticStatusService.select(id)

}
