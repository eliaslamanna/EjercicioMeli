package app.mapper;

import static app.mapper.ShipdataDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import model.Shipdata;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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
    BasicColumn[] selectList = BasicColumn.columnList(id, name, distance, message);

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
    int insert(InsertStatementProvider<Shipdata> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Shipdata> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShipdataResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="distance", property="distance", jdbcType=JdbcType.REAL),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR)
    })
    List<Shipdata> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShipdataResult")
    Optional<Shipdata> selectOne(SelectStatementProvider selectStatement);

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
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(Shipdata record) {
        return MyBatis3Utils.insert(this::insert, record, shipdata, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(distance).toProperty("distance")
            .map(message).toProperty("message")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<Shipdata> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shipdata, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(distance).toProperty("distance")
            .map(message).toProperty("message")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(Shipdata record) {
        return MyBatis3Utils.insert(this::insert, record, shipdata, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(distance).toPropertyWhenPresent("distance", record::getDistance)
            .map(message).toPropertyWhenPresent("message", record::getMessage)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Shipdata> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Shipdata> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Shipdata> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shipdata, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Shipdata> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
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
    static UpdateDSL<UpdateModel> updateAllColumns(Shipdata record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(distance).equalTo(record::getDistance)
                .set(message).equalTo(record::getMessage);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Shipdata record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(distance).equalToWhenPresent(record::getDistance)
                .set(message).equalToWhenPresent(record::getMessage);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(Shipdata record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(distance).equalTo(record::getDistance)
            .set(message).equalTo(record::getMessage)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(Shipdata record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(distance).equalToWhenPresent(record::getDistance)
            .set(message).equalToWhenPresent(record::getMessage)
            .where(id, isEqualTo(record::getId))
        );
    }
}