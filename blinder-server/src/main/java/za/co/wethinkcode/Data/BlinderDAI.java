package za.co.wethinkcode.Data;

import java.util.List;
import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

public interface BlinderDAI extends BaseQuery {

    @Update(
            "INSERT INTO profiles ( name, surname, email, age, gender, hash ) "
                    + "VALUES (?{1}, ?{2}, ?{3}, ?{4}, ?{5}, ?{6})"
    )
    void addProfile(String name, String surname, String email, int age, String gender, String hash);

    @Select(
            "SELECT * FROM profiles WHERE id=?{1}"
    )
    ProfileDO getProfileById(int id);

    @Select(
            "SELECT * FROM profiles WHERE email=?{1}"
    )
    ProfileDO getProfileByEmail(String email);

    @Select(
            "SELECT hash FROM profiles WHERE email=?{1}"
    )
    String getHAshByEmail(String email);

}