# IDEA自定义注释模板

### 1.修改类头的文档注释信息

##### 效果：

​	![59288112517](C:\Users\ADMINI~1\AppData\Local\Temp\1592881125175.png)

##### 步骤：

Editor – File and Code Templates

![59288136441](C:\Users\ADMINI~1\AppData\Local\Temp\1592881364418.png)



```
/**
@Author: 野马哥
@Description:
@Date Created in  ${YEAR}-${MONTH}-${DAY} ${TIME}
@Modified By:
*/
```

直接在右边的文件框里编辑你说需要注释的东西，然后应用保存之后,当你创建类的时候就会自动生成注释。

### 2.**方法注释模板**：

##### 效果

![59288217996](C:\Users\ADMINI~1\AppData\Local\Temp\1592882179968.png)

##### 步骤：

打开file->setting->Editor->LiveTemplates点击右边上面那个+号，选择Template Group，然后弹出一个窗口，起个文艺的名字，比如MyGroup然后点击OK

![59288161332](C:\Users\ADMINI~1\AppData\Local\Temp\1592881613329.png)



还是在file->setting->Editor->LiveTemplates这个路径下点击一下刚刚你添加的那个名字MyGroup，然后点击右边上面那个+号，选择LiveTemplate，填写下面的图上的框

![59288189418](C:\Users\ADMINI~1\AppData\Local\Temp\1592881894185.png)



*

* @Description 
  $params$
* @Return $return$
* @Author 野马哥
* @Date Created in $date$ $time$
  **/

![59288209379](C:\Users\ADMINI~1\AppData\Local\Temp\1592882093797.png)

params的值为：

groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {result+='* @param ' + params[i] + ((i < params.size() - 1) ? '\\r\\n' : '')}; return result", methodParameters()) 



点击ok，试试你刚才设置的效果