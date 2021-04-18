package app.mapper;

import static app.mapper.ShipdataDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import app.model.Satellitedata;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ShipdataMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(name, distance, message);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Satellitedata> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Satellitedata> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShipdataResult", value = {
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="distance", property="distance", jdbcType=JdbcType.REAL),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR)
    })
    List<Satellitedata> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShipdataResult")
    Optional<Satellitedata> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(String name_) {
        return delete(c -> 
            c.where(name, isEqualTo(name_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(Satellitedata record) {
        return MyBatis3Utils.insert(this::insert, record, shipdata, c ->
            c.map(name).toProperty("name")
            .map(distance).toProperty("distance")
            .map(message).toProperty("message")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<Satellitedata> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shipdata, c ->
            c.map(name).toProperty("name")
            .map(distance).toProperty("distance")
            .map(message).toProperty("message")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(Satellitedata record) {
        return MyBatis3Utils.insert(this::insert, record, shipdata, c ->
            c.map(name).toPropertyWhenPresent("name", record::getName)
            .map(distance).toPropertyWhenPresent("distance", record::getDistance)
            .map(message).toPropertyWhenPresent("message", record::getMessage)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Satellitedata> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Satellitedata> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Satellitedata> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Satellitedata> selectByPrimaryKey(String name_) {
        return selectOne(c ->
            c.where(name, isEqualTo(name_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Satellitedata record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName)
                .set(distance).equalTo(record::getDistance)
                .set(message).equalTo(record::getMessage);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Satellitedata record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName)
                .set(distance).equalToWhenPresent(record::getDistance)
                .set(message).equalToWhenPresent(record::getMessage);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(Satellitedata record) {
        return update(c ->
            c.set(distance).equalTo(record::getDistance)
            .set(message).equalTo(record::getMessage)
            .where(name, isEqualTo(record::getName))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(Satellitedata record) {
        return update(c ->
            c.set(distance).equalToWhenPresent(record::getDistance)
            .set(message).equalToWhenPresent(record::getMessage)
            .where(name, isEqualTo(record::getName))
        );
    }

    //Metodos custom
    @Select("SELECT * FROM satellitedata WHERE name=#{name}")
    Satellitedata selectSatelliteByName(@Param("name") String name);

    @Select("SELECT * FROM satellitedata ORDER BY name")
    List<Satellitedata> selectAll();

    @Update(
            "INSERT INTO satellitedata (name,distance,message)" +
            "VALUES (#{name},#{distance},#{message})" +
            "ON DUPLICATE KEY UPDATE" +
            "    distance=VALUES(distance)," +
            "    message=VALUES(message)"
    )
    void insertSatellite(@Param("name") String name, @Param("distance") float distance, @Param("message") String message);
}