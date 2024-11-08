package com.searchingsortingbigopartb.prework;

import java.util.List;

/**
 * Manages a list of AmazonPackages.
 * Individual packages can be found by ASIN.
 */
public class AmazonOrderService {

    private List<AmazonPackage> packages;

    /**
     * Constructs an AmazonOrderService object.
     * @param packages - The List of packages in the order
     */
    public AmazonOrderService(List<AmazonPackage> packages) {
        this.packages = packages;
    }

    /**
     * Does a linear search for a package in the known list of packages
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageLinear(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a linear search for a package matching the requested ASIN
        for (AmazonPackage pkg : this.packages) {
            if (pkg.getAsin().equals(asin)) {
                return pkg;
            }
        }
        throw new PackageNotFoundException("Package not found");
    }

    /**
     * Does a binary search for a package in the known list of packages
     * Note: You should assume that the package list is already sorted when this method is called.
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageBinary(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a binary search for a package matching the requested ASIN

        AmazonPackage targetPackage;

        int beginning = 0;
        int end = packages.size() - 1;
        int pointer;

        while (beginning <= end) {
            pointer = (beginning + end)/2;
            int result = this.packages.get(pointer).getAsin().compareTo(asin);
            if (result == 0) {
                return this.packages.get(pointer);
            } else if (result < 0) {
                beginning = pointer + 1;
            } else {
                end = pointer -1;
            }
        }

        throw new PackageNotFoundException("Package not found");


    }
}
