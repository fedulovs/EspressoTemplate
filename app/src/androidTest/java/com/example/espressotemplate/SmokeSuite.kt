package com.example.espressotemplate

import org.junit.runner.RunWith
import org.junit.runners.Suite

// Combining tests from different classes in one suite
@RunWith(Suite::class)
@Suite.SuiteClasses(
    ActivityTest::class,
    NavigationSuite::class
)
class SmokeSuite