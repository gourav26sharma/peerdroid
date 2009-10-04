/*
 * Copyright (c) 2001 Sun Microsystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *       Sun Microsystems, Inc. for Project JXTA."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Sun", "Sun Microsystems, Inc.", "JXTA" and "Project JXTA" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written
 *    permission, please contact Project JXTA at http://www.jxta.org.
 *
 * 5. Products derived from this software may not be called "JXTA",
 *    nor may "JXTA" appear in their name, without prior written
 *    permission of Sun.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL SUN MICROSYSTEMS OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of Project JXTA.  For more
 * information on Project JXTA, please see
 * <http://www.jxta.org/>.
 *
 * This license is based on the BSD license adopted by the Apache Foundation.
 *
 * $Id: Authenticator.java,v 1.1 2005/05/03 06:29:43 hamada Exp $
 */

package net.jxta.membership;

import net.jxta.credential.AuthenticationCredential;

/**
 * An Authenticator is returned by the
 * {@linkplain MembershipService#apply(AuthenticationCredential) apply()} to the
 * Membership Service of a peergroup. The Membership
 When the authenticator has been completed it is
 * returned to the Membership Service via the "Join" operation.
 *
 * <p/>The mechanism for completing the authentication object is unique for each
 * authentication method. (That's the whole point of writing a Membership
 * Service). The only common operation is <code>isReadyForJoin</code>, which
 * provides information as to whether you have completed the authenticator
 * correctly.
 *
 * @see net.jxta.membership.MembershipService
 * @see net.jxta.credential.Credential
 * @see net.jxta.credential.AuthenticationCredential
 */
public interface Authenticator {
    
    /**
     *  Returns the name of this authentication method. This should be the same
     *  name which was used in the Authentication credential.
     *
     *  @return String containing the name of this authentication method.
     **/
    public String getMethodName();
    
    /**
     * Return the Authentication Credential associated with this authenticator,
     * if any.
     *
     * @return the AutheticationCredential which was provided to the
     * {@link MembershipService#apply(AuthenticationCredential)}.
     **/
    public AuthenticationCredential getAuthenticationCredential();
    
    /**
     * Returns the service which generated this authenticator. This is the
     * service which provided this authenticator and the service which will
     * accept this authenticator when the authenticator is
     * completed.
     *
     * @return the MembershipService service associated with this authenticator.
     **/
    public MembershipService  getSourceService();
    
    /**
     * Returns true if this Authenticator has been satisfied and is ready
     * for submission to {@link MembershipService#join(Authenticator)}. Some
     * authenticators may behave asynchronously and this method can be used to
     * determine if the authentication process has completed.
     * <p/>This method provides no distinction between incomplete authentication
     * and failed authentication.
     *
     * @see MembershipService#join(Authenticator)
     *
     * @return true if the authenticator object is complete and ready for
     * submitting to the Membership Service service for 
     * {@link MembershipService#join(Authenticator)}, otherwise false.
     **/
    public boolean  isReadyForJoin();
}
