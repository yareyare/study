package mapReduce;

/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年7月7日 下午2:42:24
 * @version 1.0
 */
public class Employee {
    private String name;
    private Integer age;
    private String company;

    public Employee(String name, Integer age, String company) {
        this.name = name == null ? "guest" : name;
        this.age = age == null ? 30 : age;
        this.company = company == null ? "DevCode" : company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", company=" + company + "]";
    }
    
}
