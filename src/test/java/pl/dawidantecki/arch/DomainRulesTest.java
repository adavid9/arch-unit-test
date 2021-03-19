package pl.dawidantecki.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import java.io.Serializable;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * @author: Dawid Antecki
 * @created: 03/19/2021 7:18 PM
 * @version: 1.0
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "pl.dawidantecki.arch")
public class DomainRulesTest {

    @ArchTest
    public static final ArchRule domain_classes_should_implement_serializable_interface =
            classes().that().resideInAPackage("..domain").should().implement(Serializable.class);
}
