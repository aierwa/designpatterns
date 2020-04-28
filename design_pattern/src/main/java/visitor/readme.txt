
访问者模式

实现 pdf，word 等格式的资源 的 抽取文本、压缩等功能
mode1: 普通实现
    将 pdf，word 抽象成资源，并且在资源中定义各个方法如 extract2txt, compress
    缺点：如果后期要加 方法的话，要修改每个文件

mode2：访问者模式 实现
    将 pdf，word 抽象成资源，并且定义一个抽象的访问方法 abstract void accept(Visitor visitor);
    相当于是说，我这个资源，接收某个 visitor，通过 visitor，去执行具体的逻辑
    Visitor 定义成接口类，并有各个资源的 visit 方法，如 visit(PdfFile pdf), visit(WordFile word) 等
    具体业务逻辑就写在 Visitor 实现类的 visit 方法中
    资源的具体实现类只需要将 accept 的 visit 方法执行 this 即可：accept(Visitor visitor){ visitor.visit(this); }

可见，访问者模式的场景是：
    一个或多个操作（extract2txt,compress）应用到一组对象中（PdfFile,WordFile），解耦操作和对象本身。

