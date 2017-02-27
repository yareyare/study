package mapReduce;


/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年7月7日 下午2:46:02
 * @version 1.0
 */
class Builder {
    String name, company;
    Integer age;

    Builder(String name) {
        this.name = name;

    }

    Employee build() {
        return new Employee(name, age, company);
    }

    Builder age(Integer age) {
        this.age = age;
        return this;
    }

    Builder company(String company) {
        this.company = company;
        return this;
    }
}
