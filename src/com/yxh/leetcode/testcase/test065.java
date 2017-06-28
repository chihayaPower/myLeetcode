package com.yxh.leetcode.testcase;

/*
 * 65. Valid Number-leetcode-java
发表于 2016/02/10
题目：

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

更新：午饭之后再来战，终于把几个case 过了，终于AC了。。。

回顾自己的第一次AC，真的是为了AC而AC，应有的思路应该是先分析好问题，再解决问题。不过，wrong answer那么多次最后没有狗带，也是蛮幸运。。。

题意就是给定一个字符串，判断是否合法，期间注意考虑各种情况，合法的不合法的。case好多啊……此题整了一上午，最终以1458/1481 case之后觉得无力再爱

1458/1481 case的代码，我觉得还可以完善的。。

case到这里，我发现我只是在做题，对于e我一直没想明白这样表示是啥，为啥无理数e放在这里，不怕被鄙视，我承认我一直想的是无理数。后来百度了下，才恍然。所以，对于'e'，最多只允许出现1次，其前后都必须有数字，但后面一定是整数，即不能出现'.'；

引自百度：3.2e10是计算器显示的结果.是显示的科学计数法,e代表的意思是x10的n次方,也就是3.2X10的10次方.

我就是用普通方法判断各种case的。在家里比较闲，截取了部分提交历史。。









在经历了N多次的提交，wrong answer外加几次超时，最终终于修改成功，AC了。。。

以下是pass的Java代码，其实就是根据case来的，每次看看又有啥case没有过，就继续加条件……


然后去百度了。。结果发现用 有限状态机 做，会很方便，那么接下来要学习这个方法。

http://blog.csdn.NET/suwei19870312/article/details/12094233  这篇文章讲的有限状态机挺好的。

还有一篇 http://noalgo.info/995.html

更新：啊，又发现一个超级简洁的方法，其实人家可能考察的只是正则表达式，代码好短啊！好惭愧。

网上的解法：
 */

public class test065 {
    public boolean isNumber(String s) { 
        if(s.trim().isEmpty()){ 
            return false; 
        } 
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"; 

        if(s.trim().matches(regex)){ 
            return true; 
        }else{ 
            return false; 
        } 
    } 
}
